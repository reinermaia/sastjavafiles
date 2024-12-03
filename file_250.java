	private void readPropertyFile()
	{
		java.util.Properties props = new java.util.Properties();
	    try
	    {
	        File propertyFile = new File(propertyFilePath + File.separator + PROPERTYFILENAME);
	        if (propertyFile.exists())
	        {
	        	java.io.FileInputStream fis = null;
	        	try
	        	{
			    	fis = new java.io.FileInputStream(propertyFile);
			        props.load(fis);
	        	}
	        	finally
	        	{
	        		if (fis!=null) try { fis.close(); } catch (IOException ex) { Log.error("IGNORED", ex); }
	        	}
	        }

	        searchPath = props.getProperty(PROPERTY_SEARCHPATH, Helpers.HOMEDIR);
			exportPath = props.getProperty(PROPERTY_EXPORTPATH, Helpers.HOMEDIR);
			uiClassName = props.getProperty(PROPERTY_LOOKANDFEEL, javax.swing.UIManager.getSystemLookAndFeelClassName());
			useSystemTray = Boolean.parseBoolean(props.getProperty(PROPERTY_SYSTEMTRAY, "FALSE"));
			currentVolume = Float.parseFloat(props.getProperty(PROPERTY_VOLUME_VALUE, "1.0"));
			currentBalance = Float.parseFloat(props.getProperty(PROPERTY_BALANCE_VALUE, "0.0"));
			lastLoaded = new ArrayList<URL>(PROPERTY_LASTLOADED_MAXENTRIES);
			for (int i=0; i<PROPERTY_LASTLOADED_MAXENTRIES; i++)
			{
				String url = props.getProperty(PROPERTY_LASTLOADED+'.'+i, null);
				if (url!=null) lastLoaded.add(new URL(url)); else lastLoaded.add(null);
			}
			setDSPEnabled(Boolean.parseBoolean(props.getProperty(PROPERTY_EFFECTS_PASSTHROUGH, "FALSE")));
			mainDialogLocation = Helpers.getPointFromString(props.getProperty(PROPERTY_MAINDIALOG_POS, "-1x-1"));
			mainDialogSize = Helpers.getDimensionFromString(props.getProperty(PROPERTY_MAINDIALOG_SIZE, "320x410"));
			playerSetUpDialogLocation = Helpers.getPointFromString(props.getProperty(PROPERTY_SETUPDIALOG_POS, "-1x-1"));
			playerSetUpDialogSize = Helpers.getDimensionFromString(props.getProperty(PROPERTY_SETUPDIALOG_SIZE, "720x230"));
			playerSetUpDialogVisable = Boolean.parseBoolean(props.getProperty(PROPERTY_SETUPDIALOG_VISABLE, "false"));
			modInfoDialogLocation = Helpers.getPointFromString(props.getProperty(PROPERTY_PROPERTIESDIALOG_POS, "-1x-1"));
			modInfoDialogSize = Helpers.getDimensionFromString(props.getProperty(PROPERTY_PROPERTIESDIALOG_SIZE, "520x630"));
			modInfoDialogVisable = Boolean.parseBoolean(props.getProperty(PROPERTY_PROPERTIESDIALOG_VISABLE, "false"));
			playlistDialogLocation = Helpers.getPointFromString(props.getProperty(PROPERTY_PLAYLISTDIALOG_POS, "-1x-1"));
			playlistDialogSize = Helpers.getDimensionFromString(props.getProperty(PROPERTY_PLAYLISTDIALOG_SIZE, "400x400"));
			playlistDialogVisable = Boolean.parseBoolean(props.getProperty(PROPERTY_PLAYLIST_VISABLE, "false"));
			effectsDialogLocation = Helpers.getPointFromString(props.getProperty(PROPERTY_EFFECTDIALOG_POS, "-1x-1"));
			effectsDialogSize = Helpers.getDimensionFromString(props.getProperty(PROPERTY_EFFECTDIALOG_SIZE, "560x470"));
			effectDialogVisable = Boolean.parseBoolean(props.getProperty(PROPERTY_EFFECT_VISABLE, "false"));
			
			if (currentEqualizer!=null)
			{
				boolean isActive = Boolean.parseBoolean(props.getProperty(PROPERTY_EQUALIZER_ISACTIVE, "FALSE"));
				currentEqualizer.setIsActive(isActive);
				float preAmpValueDB = Float.parseFloat(props.getProperty(PROPERTY_EQUALIZER_PREAMP, "0.0"));
				currentEqualizer.setPreAmp(preAmpValueDB);
				for (int i=0; i<currentEqualizer.getBandCount(); i++)
				{
					float bandValueDB = Float.parseFloat(props.getProperty(PROPERTY_EQUALIZER_BAND_PREFIX + Integer.toString(i), "0.0"));
					currentEqualizer.setBand(i, bandValueDB);
				}
			}
			if (currentPitchShift!=null)
			{
				boolean isActive = Boolean.parseBoolean(props.getProperty(PROPERTY_PITCHSHIFT_ISACTIVE, "FALSE"));
				currentPitchShift.setIsActive(isActive);
				float pitchValue = Float.parseFloat(props.getProperty(PROPERTY_PITCHSHIFT_PITCH, "1.0"));
				currentPitchShift.setPitchScale(pitchValue);
				float scaleValue = Float.parseFloat(props.getProperty(PROPERTY_PITCHSHIFT_SAMPLESCALE, "1.0"));
				currentPitchShift.setSampleScale(scaleValue);
				int overSampling = Integer.parseInt(props.getProperty(PROPERTY_PITCHSHIFT_OVERSAMPLING, "32"));
				currentPitchShift.setFFTOversampling(overSampling);
				int frameSize = Integer.parseInt(props.getProperty(PROPERTY_PITCHSHIFT_FRAMESIZE, "8192"));
				currentPitchShift.setFFTFrameSize(frameSize);
			}

			MultimediaContainerManager.configureContainer(props);
	    }
	    catch (Throwable ex)
	    {
			Log.error("[MainForm]", ex);
	    }
	}