  private <A extends ArgsBase>
  int parseCommandOption(Command<? super A> command,
                         A args,
                         String arg,
                         int i)
  {
    final String []argv = args.getRawArgv();
    OptionCommandLine<? super A> option = command.getOption(arg);

    if (option != null) {
      i = option.parse(args, argv, i);
    }
    else if (arg.startsWith("--") && arg.indexOf("=") > 0) {
      int p = arg.indexOf("=");
      
      String key = arg.substring(2, p);
      String value = arg.substring(p + 1);
      
      args.property(key, value);
    }
    else if (arg.startsWith("-")) {
      throw new CommandArgumentException(L.l("'{0}' is an unexpected option for {1}.",
                                             arg,
                                             command.name()));
    }
    else if (command.getTailArgsMinCount() >= 0) {
      args.addTailArg(arg);
    }
    else {
      throw new CommandArgumentException(L.l("'{0}' is an unexpected argument for {1}.",
                                             arg,
                                             command.name()));
    }

    return i;
  }