import numpy as np
import math
import os,sys
from mle import var, Normal

def sfa_inner(lnrptA, lnmptA, SBInvestRatioA, fundScaleA, ALRatioA, institutionRatioA):
	# Define model
	lnrpt = var('lnrpt', observed=True, vector=True)
	lnmpt = var('lnmpt', observed=True, vector=True)
	SBInvestRatio = var('SBInvestRatio', observed=True, vector=True)
	fundScale = var('fundScale', observed=True, vector=True)
	ALRatio = var('ALRatio', observed=True, vector=True)
	institutionRatio = var('institutionRatio', observed=True, vector=True)

	a1 = var('a1')
	a2 = var('a2')
	a3 = var('a3')
	a4 = var('a4')
	b0 = var('b0')
	b1 = var('b1')
	sigma = var('sigma')

	model = Normal(lnrpt, b1 * lnmpt + (a1 * SBInvestRatio) + (a2 * fundScale) + (a3 * ALRatio) + (a4 * institutionRatio) + b0, sigma)

	# Fit model to data
	result = model.fit({'lnrpt': lnrptA, 'lnmpt': lnmptA, 
		'SBInvestRatio': SBInvestRatioA, 'fundScale': fundScaleA,
		'ALRatio': ALRatioA, 'institutionRatio': institutionRatioA}, 
		{'a1': 1, 'a2': 1, 'a3': 1, 'a4': 1, 'b0': 1, 'b1': 1, 'sigma': 1})
	
	return result.x['b1'];

'''
def sfa_wrapper(param_list):
	return sfa_inner(param_list[0], param_list[1], param_list[2], param_list[3], param_list[4], param_list[5])
'''
def sfa_wrapper(param_list):
	return score_fund(param_list[0], param_list[1], param_list[2], param_list[3], param_list[4], param_list[5], param_list[6])

def param_reader():
	param_list = []
	fileHandler = open(sys.path[0] + os.sep +  'PythonParam.txt', 'r')
	for line in fileHandler.readlines():
		line_param = []
		for param in line.split(" "):
			line_param.append(float(param))

		param_list.append(np.array(line_param))

	return param_list

def sfa():
	param_list = param_reader()
	return sfa_wrapper(param_list)

def score_fund(rpt, csi300, treasury_bond_index, SBInvestRatio, fundScale, ALRatio, institutionRatio):
	mpt = 0.8 * (csi300) + 0.2 * (treasury_bond_index)

	lnrpt = np.log(rpt)
	lnmpt = np.log(mpt)

	return sfa_inner(lnrpt, lnmpt, SBInvestRatio, fundScale, ALRatio, institutionRatio)




res = sfa()
fileHandler = open(sys.path[0] + os.sep + "PythonResult.txt", 'w')
ret = str(res)
fileHandler.write(ret)
fileHandler.flush()
fileHandler.close()
