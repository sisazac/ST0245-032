
def subset(s, base = ""):
 permutations2(base,s)
  

def permutations2(base, stri):
    if len(stri)==0:
        print (base)
    for i in range(len(stri)):
        for j in range(len(stri)):
           permutations2(stri[i]+base,stri[0:j]+stri[j+1:])
           