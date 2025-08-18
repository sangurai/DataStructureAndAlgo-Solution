###
#1. Check if string is balance
    #balance when () {} []
print("###")
stack = []
testCase = ["as s ( ) s", "( sss }" , " (()"]
def isEmpty(s) : 
    if len(s) == 0 :
        return True
    else : 
        return False 
def balanceTester(text) : 
    for i in text : 
        match i :
            case "(" : 
                stack.append(i)
            case "[" :
                stack.append(i)
            case "{" :
                stack.append(i)
            case ")" :

                if stack[-1] != "(" or isEmpty(stack) :
                       return False
                stack.pop()
            case "]" :
                if stack[-1] != "[" or isEmpty(stack) :
                       return False
                stack.pop()
            case "}" :
                if stack[-1] != "{" or isEmpty(stack) :
                       return False
                stack.pop()
    return not stack
    
    #run test case
for i in testCase :
    if balanceTester(i) : 
        print(i + " is balance")
    else :
        print(i + " is not balance")
print("###\n")
###

#2.

#3. Generate all posible subset of T
#T = {1, 2 ,3}, subs = {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}
import itertools
def findSubSets(s, m) :
    return set(itertools.combinations(s, m)) 
subsets = [1, 2, 3]
ss = findSubSets(subsets, 3)
print(ss)