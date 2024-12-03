    private void printSearchFormToHtml(Set<String> fieldHash, String terms, String query, PrintWriter html) {
        html.append("<form method=\"post\" action=\"search\">"
                + "<center><table border=0 cellpadding=6 cellspacing=0>\n"
                + "<tr><td colspan=3 valign=top><i>Fields to display:</i></td><td></td></tr>"
                + "<tr><td valign=top><font size=-1>"
                + "<input type=\"checkbox\" name=\"pid\" value=\"true\" checked> <a href=\"#\" onClick=\"javascript:alert('Persistent Identfier\\n\\nThe globally unique identifier of the resource.')\">pid</a><br>"
                + "<input type=\"checkbox\" name=\"label\" value=\"true\"");
        html.append(fieldHash.contains("label") ? " checked"
                                : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Label\\n\\nThe label of the object')\">label</a><br>"
                + "<input type=\"checkbox\" name=\"state\" value=\"true\"");
        html.append(fieldHash.contains("state") ? CHECKED
                                : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('State\\n\\nThe state of the object.\\nThis will be:\\n  A - Active')\">state</a><br>"
                + "<input type=\"checkbox\" name=\"ownerId\" value=\"true\"");
        html.append(fieldHash.contains("ownerId") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Owner Id\\n\\nThe userId of the user who owns the object.')\">ownerId</a><br>"
                + "<input type=\"checkbox\" name=\"cDate\" value=\"true\"");
        html.append(fieldHash.contains("cDate") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Creation Date\\n\\nThe UTC date the object was created,\\nin YYYY-MM-DDTHH:MM:SS.SSSZ format')\">cDate</a><br>"
                 + "<input type=\"checkbox\" name=\"mDate\" value=\"true\"");
        html.append(fieldHash.contains("mDate") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Modified Date\\n\\nThe UTC date the object was last modified,\\nin YYYY-MM-DDTHH:MM:SS.SSSZ format')\">mDate</a><br>"
                + "<input type=\"checkbox\" name=\"dcmDate\" value=\"true\"");
        html.append(fieldHash.contains("dcmDate") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Dublin Core Modified Date\\n\\nThe UTC date the DC datastream was last modified,\\nin YYYY-MM-DDTHH:MM:SS.SSSZ format')\">dcmDate</a><br>"
                + "</font></td><td valign=top><font size=-1>"
                + "<input type=\"checkbox\" name=\"title\" value=\"true\" checked> <a href=\"#\" onClick=\"javascript:alert('Title\\n\\nA name given to the resource.\\nThis is a repeating field.')\">title</a><br>"
                + "<input type=\"checkbox\" name=\"creator\" value=\"true\"");
        html.append(fieldHash.contains("creator") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Creator\\n\\nAn entity primarily responsible for making\\nthe content of the resource.\\nThis is a repeating field.')\">creator</a><br>"
                + "<input type=\"checkbox\" name=\"subject\" value=\"true\"");
        html.append(fieldHash.contains("subject") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Subject and Keywords\\n\\nA topic of the content of the resource.\\nThis is a repeating field.')\">subject</a><br>"
                + "<input type=\"checkbox\" name=\"description\" value=\"true\"");
        html.append(fieldHash.contains("description") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Description\\n\\nAn account of the content of the resource.\\nThis is a repeating field.')\">description</a><br>"
                + "<input type=\"checkbox\" name=\"publisher\" value=\"true\"");
        html.append(fieldHash.contains("publisher") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Publisher\\n\\nAn entity responsible for making the resource available.\\nThis is a repeating field.')\">publisher</a><br>"
                + "<input type=\"checkbox\" name=\"contributor\" value=\"true\"");
        html.append(fieldHash.contains("contributor") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Contributor\\n\\nAn entity responsible for making contributions\\nto the content of the resource.\\nThis is a repeating field.')\">contributor</a><br>"
                + "<input type=\"checkbox\" name=\"date\" value=\"true\"");
        html.append(fieldHash.contains("date") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Date\\n\\nA date of an event in the lifecycle of the resource.\\nThis is a repeating field.')\">date</a><br>"
                + "</font></td><td valign=top><font size=-1>"
                + "<input type=\"checkbox\" name=\"type\" value=\"true\"");
        html.append(fieldHash.contains("type") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Resource Type\\n\\nThe nature or genre of the resource.\\nThis is a repeating field.')\">type</a><br>"
                + "<input type=\"checkbox\" name=\"format\" value=\"true\"");
        html.append(fieldHash.contains("format") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Format\\n\\nThe physical or digital manifestation of the resource.\\nThis is a repeating field.')\">format</a><br>"
                + "<input type=\"checkbox\" name=\"identifier\" value=\"true\"");
        html.append(fieldHash.contains("identifier") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Resource Identifier\\n\\nAn unambiguous reference to the resource within a given context.\\nThis is a repeating field.')\">identifier</a><br>"
                + "<input type=\"checkbox\" name=\"source\" value=\"true\"");
        html.append(fieldHash.contains("source") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Source\\n\\nA reference to a resource from which the present resource is derived.\\nThis is a repeating field.')\">source</a><br>"
                + "<input type=\"checkbox\" name=\"language\" value=\"true\"");
        html.append(fieldHash.contains("language") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Language\\n\\nA language of the intellectual content of the resource.\\nThis is a repeating field.')\">language</a><br>"
                + "<input type=\"checkbox\" name=\"relation\" value=\"true\"");
        html.append(fieldHash.contains("relation") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Relation\\n\\nA reference to a related resource.\\nThis is a repeating field.')\">relation</a><br>"
                + "<input type=\"checkbox\" name=\"coverage\" value=\"true\"");
        html.append(fieldHash.contains("coverage") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Coverage\\n\\nThe extent or scope of the content of the resource.\\nThis is a repeating field.')\">coverage</a><br>"
                + "<input type=\"checkbox\" name=\"rights\" value=\"true\"");
        html.append(fieldHash.contains("rights") ? CHECKED : "");
        html.append("> <a href=\"#\" onClick=\"javascript:alert('Rights Management\\n\\nInformation about rights held in and over the resource.\\nThis is a repeating field.')\">rights</a><br>"
                + "</font></td><td bgcolor=silver valign=top>&nbsp;&nbsp;&nbsp;</td><td valign=top>"
                + "Search all fields for phrase: <input type=\"text\" name=\"terms\" size=\"15\" value=\"");
        if (terms != null) StreamUtility.enc(terms, html);
        html.append("\"> <a href=\"#\" onClick=\"javascript:alert('Search All Fields\\n\\nEnter a phrase.  Objects where any field contains the phrase will be returned.\\nThis is a case-insensitive search, and you may use the * or ? wildcards.\\n\\nExamples:\\n\\n  *o*\\n    finds objects where any field contains the letter o.\\n\\n  ?edora\\n    finds objects where a word starts with any letter and ends with edora.')\"><i>help</i></a><p> "
                +"Or search specific field(s): <input type=\"text\" name=\"query\" size=\"15\" value=\"");
        if (query != null) StreamUtility.enc(query, html);
        html.append("\"> <a href=\"#\" onClick=\"javascript:alert('Search Specific Field(s)\\n\\nEnter one or more conditions, separated by space.  Objects matching all conditions will be returned.\\nA condition is a field (choose from the field names on the left) followed by an operator, followed by a value.\\nThe = operator will match if the field\\'s entire value matches the value given.\\nThe ~ operator will match on phrases within fields, and accepts the ? and * wildcards.\\nThe &lt;, &gt;, &lt;=, and &gt;= operators can be used with numeric values, such as dates.\\n\\nExamples:\\n\\n  pid~demo:* description~fedora\\n    Matches all demo objects with a description containing the word fedora.\\n\\n  cDate&gt;=1976-03-04 creator~*n*\\n    Matches objects created on or after March 4th, 1976 where at least one of the creators has an n in their name.\\n\\n  mDate&gt;2002-10-2 mDate&lt;2002-10-2T12:00:00\\n    Matches objects modified sometime before noon (UTC) on October 2nd, 2002')\"><i>help</i></a><p> ");
        html.append("Maximum Results: <select name=\"maxResults\"><option value=\"20\">20</option><option value=\"40\">40</option><option value=\"60\">60</option><option value=\"80\">80</option></select> "
                + "<p><input type=\"submit\" value=\"Search\"> "
                + "</td></tr></table></center>"
                + "</form><hr size=1>");
    }