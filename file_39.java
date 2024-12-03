    public void sortIndices(SortCoupledArray_F64 sorter ) {
        if( sorter == null )
            sorter = new SortCoupledArray_F64();

        sorter.quick(col_idx,numCols+1,nz_rows,nz_values);
        indicesSorted = true;
    }