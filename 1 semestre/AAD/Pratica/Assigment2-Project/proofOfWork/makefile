#
# TOS
#

CUDA_ARCH = sm_61


clean:
	rm -f PoW24

all:	PoW24


PoW24:		PoW24.cu cMD5.h
	nvcc -arch=$(CUDA_ARCH) --compiler-options -O2,-Wall -I/usr/local/cuda/include PoW24.cu -o PoW24
