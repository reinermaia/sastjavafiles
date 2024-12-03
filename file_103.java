    private VariantGraphRanking rankTheGraph(List<List<Match>> phraseMatches, VariantGraph base) {
        // rank the variant graph
        Set<VariantGraph.Vertex> matchedVertices = new HashSet<>();
        for (List<Match> phraseMatch : phraseMatches) {
            matchedVertices.add(phraseMatch.get(0).vertex);
        }
        final VariantGraphRanking ranking = VariantGraphRanking.ofOnlyCertainVertices(base, matchedVertices);
        return ranking;
    }