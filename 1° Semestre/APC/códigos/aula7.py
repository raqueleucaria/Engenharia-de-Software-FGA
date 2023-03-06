while True:
    num = input('Digite um número [-1 encerra]: ')
    n = int(num)
    if n < 0:
        break
    resto = n % 2
    if resto == 0:
        print('n ^ 2: ', pow(n,2))
    else:
        print('n ^ 3: ', pow(n,3))
        