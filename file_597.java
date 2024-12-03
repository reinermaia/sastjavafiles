    private boolean readCMAP(FontFileReader in) throws IOException {

        unicodeMapping = new java.util.ArrayList();

        //Read CMAP table and correct mtxTab.index
        int mtxPtr = 0;

        seekTab(in, "cmap", 2);
        int numCMap = in.readTTFUShort();    // Number of cmap subtables
        long cmapUniOffset = 0;

        log.info(numCMap + " cmap tables");

        //Read offset for all tables. We are only interested in the unicode table
        for (int i = 0; i < numCMap; i++) {
            int cmapPID = in.readTTFUShort();
            int cmapEID = in.readTTFUShort();
            long cmapOffset = in.readTTFULong();

            log.debug("Platform ID: " + cmapPID + " Encoding: " + cmapEID);

            if (cmapPID == 3 && cmapEID == 1) {
                cmapUniOffset = cmapOffset;
            }
        }

        if (cmapUniOffset <= 0) {
            log.fatal("Unicode cmap table not present");
            log.fatal("Unsupported format: Aborting");
            return false;
        }

        // Read unicode cmap
        seekTab(in, "cmap", cmapUniOffset);
        int cmapFormat = in.readTTFUShort();
        /*int cmap_length =*/ in.readTTFUShort(); //skip cmap length

        log.info("CMAP format: " + cmapFormat);

        if (cmapFormat == 4) {
            in.skip(2);    // Skip version number
            int cmapSegCountX2 = in.readTTFUShort();
            int cmapSearchRange = in.readTTFUShort();
            int cmapEntrySelector = in.readTTFUShort();
            int cmapRangeShift = in.readTTFUShort();

            if (log.isDebugEnabled()) {
                log.debug("segCountX2   : " + cmapSegCountX2);
                log.debug("searchRange  : " + cmapSearchRange);
                log.debug("entrySelector: " + cmapEntrySelector);
                log.debug("rangeShift   : " + cmapRangeShift);
            }


            int[] cmapEndCounts = new int[cmapSegCountX2 / 2];
            int[] cmapStartCounts = new int[cmapSegCountX2 / 2];
            int[] cmapDeltas = new int[cmapSegCountX2 / 2];
            int[] cmapRangeOffsets = new int[cmapSegCountX2 / 2];

            for (int i = 0; i < (cmapSegCountX2 / 2); i++) {
                cmapEndCounts[i] = in.readTTFUShort();
            }

            in.skip(2);    // Skip reservedPad

            for (int i = 0; i < (cmapSegCountX2 / 2); i++) {
                cmapStartCounts[i] = in.readTTFUShort();
            }

            for (int i = 0; i < (cmapSegCountX2 / 2); i++) {
                cmapDeltas[i] = in.readTTFShort();
            }

            //int startRangeOffset = in.getCurrentPos();

            for (int i = 0; i < (cmapSegCountX2 / 2); i++) {
                cmapRangeOffsets[i] = in.readTTFUShort();
            }

            int glyphIdArrayOffset = in.getCurrentPos();

            // Insert the unicode id for the glyphs in mtxTab
            // and fill in the cmaps ArrayList

            for (int i = 0; i < cmapStartCounts.length; i++) {

                if (log.isTraceEnabled()) {
                    log.trace(i + ": " + cmapStartCounts[i]
                                                         + " - " + cmapEndCounts[i]);
                }

                for (int j = cmapStartCounts[i]; j <= cmapEndCounts[i]; j++) {

                    // Update lastChar
                    if (j < 256 && j > lastChar) {
                        lastChar = (short)j;
                    }

                    if (mtxPtr < mtxTab.length) {
                        int glyphIdx;
                        // the last character 65535 = .notdef
                        // may have a range offset
                        if (cmapRangeOffsets[i] != 0 && j != 65535) {
                            int glyphOffset = glyphIdArrayOffset
                                + ((cmapRangeOffsets[i] / 2)
                                    + (j - cmapStartCounts[i])
                                    + (i)
                                    - cmapSegCountX2 / 2) * 2;
                            in.seekSet(glyphOffset);
                            glyphIdx = (in.readTTFUShort() + cmapDeltas[i])
                                       & 0xffff;

                            unicodeMapping.add(new UnicodeMapping(glyphIdx, j));
                            mtxTab[glyphIdx].getUnicodeIndex().add(new Integer(j));


                            // Also add winAnsiWidth
                            List v = (List)ansiIndex.get(new Integer(j));
                            if (v != null) {
                                Iterator e = v.listIterator();
                                while (e.hasNext()) {
                                    Integer aIdx = (Integer)e.next();
                                    ansiWidth[aIdx.intValue()] 
                                        = mtxTab[glyphIdx].getWx();

                                    if (log.isTraceEnabled()) {
                                        log.trace("Added width "
                                                + mtxTab[glyphIdx].getWx()
                                                + " uni: " + j
                                                + " ansi: " + aIdx.intValue());
                                    }
                                }
                            }

                            if (log.isTraceEnabled()) {
                                log.trace("Idx: "
                                        + glyphIdx
                                        + " Delta: " + cmapDeltas[i]
                                        + " Unicode: " + j
                                        + " name: " + mtxTab[glyphIdx].getName());
                            }
                        } else {
                            glyphIdx = (j + cmapDeltas[i]) & 0xffff;

                            if (glyphIdx < mtxTab.length) {
                                mtxTab[glyphIdx].getUnicodeIndex().add(new Integer(j));
                            } else {
                                log.debug("Glyph " + glyphIdx
                                                   + " out of range: "
                                                   + mtxTab.length);
                            }

                            unicodeMapping.add(new UnicodeMapping(glyphIdx, j));
                            if (glyphIdx < mtxTab.length) {
                                mtxTab[glyphIdx].getUnicodeIndex().add(new Integer(j));
                            } else {
                                log.debug("Glyph " + glyphIdx
                                                   + " out of range: "
                                                   + mtxTab.length);
                            }

                            // Also add winAnsiWidth
                            List v = (List)ansiIndex.get(new Integer(j));
                            if (v != null) {
                                Iterator e = v.listIterator();
                                while (e.hasNext()) {
                                    Integer aIdx = (Integer)e.next();
                                    ansiWidth[aIdx.intValue()] = mtxTab[glyphIdx].getWx();
                                }
                            }

                            //getLogger().debug("IIdx: " +
                            //    mtxPtr +
                            //    " Delta: " + cmap_deltas[i] +
                            //    " Unicode: " + j +
                            //    " name: " +
                            //    mtxTab[(j+cmap_deltas[i]) & 0xffff].name);

                        }
                        if (glyphIdx < mtxTab.length) {
                            if (mtxTab[glyphIdx].getUnicodeIndex().size() < 2) {
                                mtxPtr++;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }