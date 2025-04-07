import datetime 
now = datetime.datetime.now()
totals = 0
discount = 0
item = []
quantity =[]
price = []
total = []
totals = 0
discount = 0

print("Welcome to semicolon checkout stand")
print()
customer_name = input("What is the customer's name? ")
 
items = input("What did the customer buy? ")
item.append(items)
pieces = int(input("How many pieces? "))
quantity.append(pieces)
amount = int(input("How much per unit? "))
price.append(amount)

total_amount = amount * pieces
totals = totals + total_amount
total.append(total_amount)
addi = input("Add more item? ")
while addi != "yes"  and addi != "no" :
  addi = input("Wrong input, please kindly choose YES OR NO ")
  
while addi == "yes":

  items = input("What did the customer buy? ")
  item.append(items)
  pieces = int(input("How many pieces? "))
  quantity.append(pieces)
  amount = int(input("How much per unit? "))
  price.append(amount)
  
  total_amount = amount * pieces
  totals = totals + total_amount
  total.append(total_amount)
  
  addi = input("Add more items? ")
  while addi == "no" or addi == "NO" or addi == "No":
   break
  while addi != "yes" or addi != "YES" and addi != "no":
       choice = input("Please select yes or no? ")

     
cashier_name = input("What is the cashier name? ")
      
givenDiscount = int(input("How much discount is he / she getting? "))
subTotal = totals
disc = givenDiscount / 100
discount = totals * disc
vat = subTotal * 0.175
billTotal = (subTotal + vat) - discount
print(" ")
print(" ")
print("\nSEMICOLON STORES.")
print("MAIN BRANCH")
print("LOCATION: 312, HERBERT, MACAULAY WAY, SABO YABA, LAGOS.")
print("TELL: 3484627517521")
print("DATE: ", now)
print("CASHIER'S NAME: ", cashier_name)
print("CUSTOMER'S NAME: ", customer_name)
print("=============================================================")
print(f'{"ITEM"}\t\t {"QTY"}\t\t {"PRICE"}\t\t {"TOTAL(NGN)"}')
for i in range(len(item)):
   print(f'{item[i]}\t\t {quantity[i]}\t\t {price[i]}\t\t {total[i]} ')
print("---------------------------------------------------------------") 
print('\t\t\t\t', "Sub total: ", totals)
print('\t\t\t\t', "Discount: ", discount)
print('\t\t\t\t', "VAT @ 17.50%: ", vat)
print("=============================================================")
print('\t\t\t\t', "Bill total: ", billTotal)
print("=============================================================")
print('\t', "THIS IS NOT AN RECEIPT KINDLY PAY ", billTotal)
print("=============================================================")
paid_amount = int(input("How much did the customer give to you? "))
balance = paid_amount - billTotal

print(" ")
print(" ")
print("\nSEMICOLON STORES.")
print("MAIN BRANCH")
print("LOCATION: 312, HERBERT, MACAULAY WAY, SABO YABO, LAGOS.")
print("TELL: 3484627517521")
print("DATE: ", now)
print("CASHIER'S NAME: ", cashier_name)
print("CUSTOMER'S NAME: ", customer_name)
print("=============================================================")
print(f'{"ITEM"}\t\t {"QTY"}\t\t {"PRICE"}\t\t {"TOTAL(NGN)"}')
for i in range(len(item)):
  print(f'{item[i]}\t\t {quantity[i]}\t\t {price[i]}\t\t {total[i]} ')
print("---------------------------------------------------------------") 
print('\t\t\t\t', "Sub total: ", totals)
print('\t\t\t\t', "Discount: ", discount)
print('\t\t\t\t', "VAT @ 17.50%: ", vat)
print("=============================================================")
print('\t\t\t\t', "Bill total: ", billTotal)
print('\t\t\t\t', "Amount paid: ", paid_amount)
print('\t\t\t\t', "Balance: ", balance)
print("=============================================================")
print('\t', "THANKS FOR YOUR PATRONAGE ")
print("=============================================================")
