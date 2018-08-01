def hanoi(topN, a = "Tower1", b = "Tower2", c = "Tower3"):
 if topN==1:
     print("Disk "+ str(topN) + " from "+ a + " to "+ c)
 hanoi(topN-1,a ,c , b)
 print("Disk "+ str(topN) + " from "+ a + " to "+ c)
 hanoi(topN-1,b ,a , c)

def subset(s, base = ""):
 permutations(base,s)
  

def permutations(base, stri):
    if len(stri)==0:
        print (base)
    for i in range(len(stri)):
        permutations(stri[i]+base,stri[0:i]+stri[i+1:])