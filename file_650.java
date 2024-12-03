    private void sevenMemberedRingPossibilities(IAtomContainer m, IRing r, List<List<List<String>>> MasterList) {
        // for now only consider case where have 3 double bonds

        IAtom[] ringatoms = new IAtom[7];

        ringatoms[0] = r.getAtom(0);

        int[] num = new int[7];

        for (int j = 0; j <= 6; j++) {
            num[j] = m.indexOf(r.getAtom(j));
        }

        List<String> al1 = new ArrayList<String>();
        List<String> al2 = new ArrayList<String>();
        List<String> al3 = new ArrayList<String>();
        List<String> al4 = new ArrayList<String>();
        List<String> al5 = new ArrayList<String>();

        al1.add(num[0] + "-" + num[1]);
        al1.add(num[2] + "-" + num[3]);
        al1.add(num[4] + "-" + num[5]);

        al2.add(num[0] + "-" + num[1]);
        al2.add(num[2] + "-" + num[3]);
        al2.add(num[5] + "-" + num[6]);

        al3.add(num[1] + "-" + num[2]);
        al3.add(num[3] + "-" + num[4]);
        al3.add(num[5] + "-" + num[6]);

        al4.add(num[1] + "-" + num[2]);
        al4.add(num[3] + "-" + num[4]);
        al4.add(num[6] + "-" + num[0]);

        al5.add(num[2] + "-" + num[3]);
        al5.add(num[4] + "-" + num[5]);
        al5.add(num[6] + "-" + num[0]);

        List<List<String>> mal = new ArrayList<List<String>>();

        mal.add(al1);
        mal.add(al2);
        mal.add(al3);
        mal.add(al4);
        mal.add(al5);

        MasterList.add(mal);

    }