    private void _getAllParents(List<String> accum, ProfileRecord profile) {

        List<String> parents = profile.getIncludes();
        for (String parent : parents) {
            _getAllParents(accum, profileStore.getProfile(parent));
        }

        accum.addAll(parents);
    }