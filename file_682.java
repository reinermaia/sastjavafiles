    public String add(BaseHolder obj)
    {
        if (m_iNextUniqueID >= Integer.MAX_VALUE)
            m_iNextUniqueID = 0;
        m_iNextUniqueID++;
        String strUniqueID = Integer.toString(m_iNextUniqueID);
        this.put(strUniqueID, obj);
        return strUniqueID;
    }