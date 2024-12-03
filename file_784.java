	private void optimize(int maxi) throws StructureException
	{
		long optStart = System.currentTimeMillis();
		if ( debug)
			System.out.println("Optimizing up to " + maxi + " iterations.. ");
		boolean ifstop = true;;
		int     i, alnLen;
		alnLen = 0;

		int[][]     alnList =  new int[2][maxLen];
		for(i = 0; i < maxi; i ++)      {

			//if ( debug){
			//   System.out.println("optimize iteration: " + i);
			//}

			calMatrix();

			FCAlignHelper aln = new FCAlignHelper(sij,pro1Len,pro2Len,gapIni, gapExt);

			//ALIGN0 *aln = new ALIGN0(sij, pro1Len, pro2Len, gapIni, gapExt);
			alnLen = aln.getAlignPos(alnList);
			if(alnLen < 3)  ifstop = true; //very rare, mark by Y.Y on 5/1/03
			else    ifstop = defineEquPos(alnLen, alnList);

			if(ifstop)      break;
			Dc += increase;

//         if (showAlig)
//            if ( i == 0 )
//               showCurrentAlignment(alnLen, alnList,  "optimizing alignment - after " + i + " iterations alnLen:" + alnLen + " rmsd " + rmsd);
		}

		if  (debug){
			if(i < maxi)    {
				System.out.println(String.format("   optimize converged at %d iterations\n", i));
			}
			else    System.out.println("   optimize stop without convergence\n");
			System.out.println("optimization time: " + (System.currentTimeMillis() - optStart) + " ms.");
		}

//      if (showAlig)
//         showCurrentAlignment(alnLen, alnList,  "optimizing alignment - after " + i + " iterations alnLen:" + alnLen + " rmsd " + rmsd);
	}