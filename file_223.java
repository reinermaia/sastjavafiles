    File guessUserDataDirectory(String packageName) {
        Integer uid = getProcessUid();
        if (uid == null) {
            // If we couldn't retrieve process uid, return null.
            return null;
        }

        // We're trying to get the ID of the Android user that's running the process. It can be
        // inferred from the UID of the current process.
        int userId = uid / PER_USER_RANGE;
        return getWriteableDirectory(String.format("/data/user/%d/%s", userId, packageName));
    }