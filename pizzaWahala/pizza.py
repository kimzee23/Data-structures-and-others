import math
import array as arr
def main():
    pizza_types = [
        "Sapa size -> 2500   |Slices = 4",
        "Small Money -> 2900 | slices = 6",
        "Big boys -> 4000 	  | Slices = 8",
        "Odogwu -> 5200 	  | Slices = 12",
        "Kings size -> 8200 	  | Slices = 16"
    ]

    slices_per_box = [4, 6, 8, 12, 16]
    prices_per_box = [2500, 2900, 4000, 5200, 8200]

    print("="*40)

    print("Welcome to Iya Moses Pizza joint!\n")


    try:
        number_of_guests = int(input("Enter the number of guests: "))
        
        print("\nChoose the type of pizza:")
        for i, pizza in enumerate(pizza_types):
            print(f"{i + 1}. {pizza}")


        pizza_choice = int(input("\n Choose the type of pizza u want to buy : "))-1	
        if pizza_choice < 0 or pizza_choice >= len(pizza_types):
            print("Invalid pizza choice. Please kindly refresh  the program.")
            return  pizza_choice
  		


        
        slices_per_guest = 1  # Assumes each guest gets 1 slice
        total_slices_needed = number_of_guests * slices_per_guest
        slices_per_box_chosen = slices_per_box[pizza_choice]
        price_per_box_chosen = prices_per_box[pizza_choice]

        boxes_needed = math.ceil(total_slices_needed / slices_per_box_chosen)
        total_slices = boxes_needed * slices_per_box_chosen
        leftover_slices = total_slices - total_slices_needed
        total_price = boxes_needed * price_per_box_chosen

    
        print("\nWhat you ordered summery:")
        print(f"Number of boxes of pizza to buy: {boxes_needed} boxs")
        print(f"Number of leftover slices: {leftover_slices} slice(s)")
        print(f"Total price: N{total_price}")
        print("="*40)
        print("Thanks for choosing us")
        print("="*40)
    
    except ValueError:
        print("Invalid input. Please enter numbers only.")

if __name__ == "__main__":
    main()
