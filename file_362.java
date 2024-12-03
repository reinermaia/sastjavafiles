    CommandLine getExecutablePath( Map<String, String> enviro, File dir )
    {
        File execFile = new File( executable );
        String exec = null;
        if ( execFile.isFile() )
        {
            getLog().debug( "Toolchains are ignored, 'executable' parameter is set to " + executable );
            exec = execFile.getAbsolutePath();
        }

        if ( exec == null )
        {
            Toolchain tc = getToolchain();

            // if the file doesn't exist & toolchain is null, the exec is probably in the PATH...
            // we should probably also test for isFile and canExecute, but the second one is only
            // available in SDK 6.
            if ( tc != null )
            {
                getLog().info( "Toolchain in exec-maven-plugin: " + tc );
                exec = tc.findTool( executable );
            }
            else
            {
                if ( OS.isFamilyWindows() )
                {
                    List<String> paths = this.getExecutablePaths( enviro );
                    paths.add( 0, dir.getAbsolutePath() );

                    exec = findExecutable( executable, paths );
                }
            }
        }

        if ( exec == null )
        {
            exec = executable;
        }

        CommandLine toRet;
        if ( OS.isFamilyWindows() && !hasNativeExtension( exec ) && hasExecutableExtension( exec ) )
        {
            // run the windows batch script in isolation and exit at the end
            final String comSpec = System.getenv( "ComSpec" );
            toRet = new CommandLine( comSpec == null ? "cmd" : comSpec );
            toRet.addArgument( "/c" );
            toRet.addArgument( exec );
        }
        else
        {
            toRet = new CommandLine( exec );
        }

        return toRet;
    }