import math
def main():
    a = [12, 1, 67, 35, 98, 2, 10, 24]
    print("Before:")
    printList(a)
    mergeSort(a)
    print("After:")
    printList(a)
    print(binarySearch(a, 98), "should be True")
    print(binarySearch(a, 12), "should be True")
    print(binarySearch(a, 13), "should be False")
    print(binarySearch(a, 24), "should be True")
    print(binarySearch(a, 57), "should be False")
    print(binarySearch(a, 10), "should be True")
    print(binarySearch(a, 67), "should be True")
    print(binarySearch(a, 120), "should be False")

def binarySearch(ar, x):
    hi = len(ar)
    lo = 0
    if(ar[hi-1] < x):
        return False
    if(ar[lo]>x):
        return False
    while(hi >= lo):
        mid = lo + (hi-lo)//2
        if(ar[mid] > x):
            hi = mid -1
        elif(ar[mid] == x):
            return True
        else:
            lo = mid + 1
        
    return False

def mergeSort(arr):
    if(len(arr) > 1):
        mid = len(arr) //2
        b = arr[:mid]
        c = arr[mid:]
        mergeSort(b)
        mergeSort(c)
        merge(b, c, arr)
def merge(b, c, a):
    p = len(b)
    q = len(c)
    n = len(a)
    i = j = k = 0
    
    #print(i, j, k)
    while(i<p and j<q):
        if(b[i] < c[j]):
            a[k] = b[i]
            i+=1
        else:
            a[k] = c[j]
            j+=1
        k+=1

    if(i == p):
        for x in range(k, n):
            a[x] = c[j]
            j+=1
    elif(j == q):
        for x in range(k, n):
            a[x] = b[i]
            i+=1
def printList(a):
    for i in range(len(a)):
        print(a[i],end=" ")
    print()
if __name__ == '__main__':
    main()