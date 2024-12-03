  private int _checkInlineHtml (final MarkdownHCStack out, final String in, final int nStart)
  {
    final StringBuilder aTmp = new StringBuilder ();

    // Check for auto links
    aTmp.setLength (0);
    int nPos = MarkdownHelper.readUntil (aTmp, in, nStart + 1, ':', ' ', '>', '\n');
    if (nPos != -1 && in.charAt (nPos) == ':' && MarkdownHTML.isLinkPrefix (aTmp.toString ()))
    {
      nPos = MarkdownHelper.readUntil (aTmp, in, nPos, '>');
      if (nPos != -1)
      {
        final String sLink = aTmp.toString ();
        final HCA aLink = m_aConfig.getDecorator ().openLink (out);
        aLink.setHref (new SimpleURL (sLink)).addChild (sLink);
        m_aConfig.getDecorator ().closeLink (out);
        return nPos;
      }
    }

    // Check for mailto or address auto link
    aTmp.setLength (0);
    nPos = MarkdownHelper.readUntil (aTmp, in, nStart + 1, '@', ' ', '>', '\n');
    if (nPos != -1 && in.charAt (nPos) == '@')
    {
      nPos = MarkdownHelper.readUntil (aTmp, in, nPos, '>');
      if (nPos != -1)
      {
        final String sLink = aTmp.toString ();
        final HCA aLink = m_aConfig.getDecorator ().openLink (out);
        if (sLink.startsWith ("@"))
        {
          // address auto links
          final String sAddress = sLink.substring (1);
          final ISimpleURL aUrl = new SimpleURL ("https://maps.google.com/maps").add ("q", sAddress);
          aLink.setHref (aUrl).addChild (sAddress);
        }
        else
        {
          // mailto auto links
          aLink.setHref (new SimpleURL ("mailto:" + sLink)).addChild (sLink);
        }
        m_aConfig.getDecorator ().closeLink (out);
        return nPos;
      }
    }

    // Check for inline html
    if (nStart + 2 < in.length ())
    {
      nPos = nStart;
      if (nStart + 3 < in.length () &&
          in.charAt (nStart + 1) == '!' &&
          in.charAt (nStart + 2) == '-' &&
          in.charAt (nStart + 3) == '-')
      {
        nPos = nStart + 4;
        final int nCommentStartPos = nPos;
        while (true)
        {
          while (nPos < in.length () && in.charAt (nPos) != '-')
            nPos++;

          if (nPos == in.length ())
          {
            // FIXME End of line in comment
            return -1;
          }
          if (nPos + 2 < in.length () && in.charAt (nPos + 1) == '-' && in.charAt (nPos + 2) == '>')
          {
            // XML comment inline
            out.append (new HCCommentNode (in.substring (nCommentStartPos, nPos)));
            return nPos + 2;
          }
          nPos++;
        }
      }

      aTmp.setLength (0);
      final int nNewPos = MarkdownHelper.readXMLElement (aTmp, in, nStart, m_aConfig.isSafeMode ());
      if (nNewPos != -1)
      {
        final String sElement = aTmp.toString ();
        if (sElement.endsWith ("/>"))
        {
          // Self closed tag - can be parsed
          final IMicroDocument aXML = MicroReader.readMicroXML (sElement);
          if (aXML == null)
            throw new MarkdownException ("Failed to parse XML: " + sElement);
          // And use the root element
          out.append (new HCDOMWrapper (aXML.getDocumentElement ().detachFromParent ()));
        }
        else
          if (sElement.startsWith ("</"))
          {
            // Closing tag
            out.pop ();
          }
          else
          {
            // Opening tag - parse as self-closed tag and push to stack
            final String sParseCode = sElement.substring (0, sElement.length () - 1) + "/>";
            final IMicroDocument aXML = MicroReader.readMicroXML (sParseCode);
            if (aXML == null)
              throw new MarkdownException ("Failed to parse XML: " + sParseCode);
            final IMicroElement eRoot = aXML.getDocumentElement ();

            // And use the root element
            final IHCElement <?> aHC = HCExtHelper.createHCElementFromName (eRoot.getTagName ());
            if (aHC == null)
              throw new MarkdownException ("Failed to get HC element: " + eRoot.getTagName ());

            // Clone all attributes
            eRoot.forAllAttributes (aAttr -> aHC.customAttrs ().putIn (aAttr.getAttributeQName (),
                                                                       aAttr.getAttributeValue ()));

            if (aHC.getElement ().mayBeSelfClosed ())
            {
              // e.g. <hr />
              out.append (aHC);
            }
            else
            {
              // Push
              out.push (aHC);
            }
          }

        return nNewPos - 1;
      }
    }

    return -1;
  }