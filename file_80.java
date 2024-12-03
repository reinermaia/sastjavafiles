    public List<WorkflowStatusCount> findWorklowStatusCount(){
        String select = "SELECT workflow_name, status, count(1) as count ";
        String where = " WHERE cluster_name = :clusterName ";
        String group = " GROUP BY workflow_name, status ";
        String sql = ""
                + select + "FROM " + getTableName( true ) + where + group
                + "UNION ALL "
                + select + "FROM " + getTableName( false ) + where + group;
        AdvancedParameterSource source = new AdvancedParameterSource()
                .addValue( "clusterName", config.getClusterName() );
        return getNamedParameterJdbcTemplate().query( sql, source, WorkflowStatusCountRowMapper.INSTANCE );
    }