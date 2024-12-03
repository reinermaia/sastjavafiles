    public TernaryVector generate() {
        HashSet<Integer> pos = new HashSet<Integer>();
        HashSet<Integer> neg = new HashSet<Integer>();
        
        // Randomly decide how many bits to set in the index vector based on the
        // variance.
        int bitsToSet = numVectorValues +
            (int)(RANDOM.nextDouble() * variance *
                  ((RANDOM.nextDouble() > .5) ? 1 : -1));

        for (int i = 0; i < bitsToSet; ++i) {
            boolean picked = false;
            // loop to ensure we actually pick the full number of bits
            while (!picked) {
                // pick some random index
                int index = RANDOM.nextInt(indexVectorLength);
                    
                // check that we haven't already added this index
                if (pos.contains(index) || neg.contains(index))
                    continue;
                    
                // decide positive or negative
                ((RANDOM.nextDouble() > .5) ? pos : neg).add(index);
                picked = true;
            }
        }
            
        int[] positive = new int[pos.size()];
        int[] negative = new int[neg.size()];

        Iterator<Integer> it = pos.iterator();
        for (int i = 0; i < positive.length; ++i) 
            positive[i] = it.next();

        it = neg.iterator();
        for (int i = 0; i < negative.length; ++i) 
            negative[i] = it.next();                

        // sort so we can use a binary search in getValue()
        Arrays.sort(positive);
        Arrays.sort(negative);
        return new TernaryVector(indexVectorLength, positive, negative);
    }