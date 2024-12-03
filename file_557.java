	@Override
	public SExportsIR caseAModuleExports(AModuleExports node, IRInfo question)
			throws AnalysisException
	{
		AModuleExportsIR moduleExportsCg = new AModuleExportsIR();

		for (List<PExport> export : node.getExports())
		{
			List<SExportIR> exportCg = new LinkedList<SExportIR>();

			for (PExport exportItem : export)
			{
				SExportIR exportItemCg = exportItem.apply(question.getExportVisitor(), question);

				if (exportItemCg != null)
				{
					exportCg.add(exportItemCg);
				} else
				{
					return null;
				}
			}

			moduleExportsCg.getExports().add(exportCg);
		}

		return moduleExportsCg;
	}