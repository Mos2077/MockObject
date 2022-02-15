package com.teste;

 
 class CaixaEletronico{
	 
	public static void main(String[] args) {
	 
	        System.out.println("Digite o valor que voc� deseja sacar");
	 
	        // c�dulas e/ou moedas poss�veis
	        int[][] aResult = {
	            {100, -1},
	            {50, -1},
	            {20, -1},
	            {10, -1},
	            {5, -1},
	            {2, -1}
	        };
	 
			int valor = 2;
			int valorcalc = 100;
	        int ninit = 1; // c�dula/moeda inicial
	        int nfim = 5; // n�mero total de c�dulas/moedas
	        float nMult = 0;
	        float nResto = 0;
	 
	        while (valorcalc != 0) {
	 
	            while ( (valorcalc != 0) && (ninit <= nfim) ) {
	 
	                valorcalc = valor;
	 
	                for (int i = 0; i <= nfim; i++) {
	                    if (aResult[i][1] == -1)
	                      aResult[i][1] = (valorcalc / aResult[i][0]);
	                   
	                    valorcalc -= (aResult[i][1] * aResult[i][0]);
	                     
	                    if (valorcalc == 0)
	                        break;
	                };
	                     
	                // se n�o conseguiu o c�lculo exato
	                if (valorcalc != 0) {
	                    if (aResult[ninit][1] > 0)
	                      aResult[ninit][1] = (aResult[ninit][1] - 1);
	 
	                    for (int i = ninit+1; i <= nfim; i++)
	                        aResult[i][1] = -1;
	 
	                    if (aResult[ninit][1] == 0)
	                        ninit++;
	                };
	 
	            };
	 
	            if (valorcalc != 0)
	                break;
	 
	        }
	 
	        // se o valor n�o foi exato
	        // avisa que o valor � inv�lido
	        if (valorcalc != 0)
	            System.out.println("O valor informado n�o pode ser sacado!");
	        else {
	            // zero as quantidades que estiverem negativas
	            for (int i = 0; i <= nfim; i++)
	                if (aResult[i][1] < 0)
	                    aResult[i][1] = 0;
	 
	            // redistribui os valores, caso necess�rio
	            for (int i = nfim; i >= 1; i--) {
	                if (aResult[i][1] > 0)
	                    for (int n = (i-1); n >= 0; n--) {
	                        nMult = ((aResult[i][1] * aResult[i][0]) / aResult[n][0]);
	                        nResto = ((aResult[i][1] * aResult[i][0]) - (nMult * aResult[n][0]));
	                        if ( (nMult > 0) && ((nResto == 0) || ((nResto % aResult[i][0]) == 0)) ) {
	                            aResult[i][1] = (aResult[i][1] - (int)((nMult * aResult[n][0]) / aResult[i][0]));
	                            aResult[n][1] = (aResult[n][1] + (int)nMult);
	                        }
	                        else {
	                            if ( (i < nfim) && (nMult > 0) && ( (nResto % aResult[i+1][0]) == 0 ) ) {
	                                aResult[i+1][1] = aResult[i+1][1] + (int)(nResto / aResult[i+1][0]);
	                                aResult[i][1] = 0;
	                                aResult[n][1] = aResult[n][1] + (int)nMult;
	                            };
	                        };
	                    };
	            }
	 
	            // redistribui os res�dios de valores, caso necess�rio
	            for (int i = nfim; i >= 1; i--) {
	                if (aResult[i][1] > 0)
	                    for (int n = (i-1); n >= 0; n--) {
	                        nMult = ((aResult[i][1] * aResult[i][0]) / aResult[n][0]);
	                        nResto = ((aResult[i][1] * aResult[i][0]) - (nMult * aResult[n][0]));
	                        if ( (nMult > 0) && ((nResto == 0) || ((nResto % aResult[i][0]) == 0)) ) {
	                            aResult[i][1] = (aResult[i][1] - (int)((nMult * aResult[n][0]) / aResult[i][0]));
	                            aResult[n][1] = (aResult[n][1] + (int)nMult);
	                        };
	                    };
	            }
	 
	            // apresenta o resultado
	            for (int i = 0; i <= nfim; i++)
	                if (aResult[i][1] > 0) {
	                    String strnota = (aResult[i][1] > 1) ? " notas " : " nota ";
	                    System.out.println(aResult[i][1] + strnota + "de R$ " + aResult[i][0]);
	                };
	        };
	    };
 };
 


