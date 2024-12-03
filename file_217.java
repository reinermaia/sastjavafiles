    public ImmutableBag<T> newWithout(T element)
    {
        int elementIndex = ArrayIterate.detectIndexWith(this.keys, Predicates2.equal(), element);
        if (elementIndex > -1)
        {
            int distinctItemCount = this.sizeDistinct() - (this.counts[elementIndex] == 1 ? 1 : 0);
            T[] newKeys = (T[]) new Object[distinctItemCount];
            int[] newCounts = new int[distinctItemCount];
            if (distinctItemCount == this.sizeDistinct())
            {
                System.arraycopy(this.keys, 0, newKeys, 0, distinctItemCount);
                System.arraycopy(this.counts, 0, newCounts, 0, distinctItemCount);
                newCounts[elementIndex]--;
            }
            else
            {
                System.arraycopy(this.keys, 0, newKeys, 0, elementIndex);
                System.arraycopy(this.counts, 0, newCounts, 0, elementIndex);
                System.arraycopy(this.keys, elementIndex + 1, newKeys, elementIndex, newKeys.length - elementIndex);
                System.arraycopy(this.counts, elementIndex + 1, newCounts, elementIndex, newCounts.length - elementIndex);
            }
            return new ImmutableArrayBag<T>(newKeys, newCounts);
        }
        return this;
    }