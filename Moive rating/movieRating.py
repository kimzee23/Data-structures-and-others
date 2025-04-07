import datetime  
def display_menu():
    print(f"="*40)
    print("1. Add a Movie")
    print("2. Veiw the movies")
    print("3. Rate a Movie")
    print("4. View Average Ratings")
    print("5. Exit....! \U0001F44B\U0001F6AA")

def get_add_movie():
    while True:
        try:
            get_date()
            name_of_moveies = input("Enter movie name: ").strip()
            if name_of_moveies:
                return name_of_moveies.lower() 
            print("Invalid input. Please enter a valid movie name.")
        except Exception as e:
            print(f"Kindly input a movie name: {e}. Please try again.")

def get_date():
   dating = datetime.datetime.now()
   print(dating.strftime("%Y, %B, %d, %I:%M %p"))

def get_rating_movie():
    while True:
        try:
            get_date()
            rating = float(input("Rate the movie between (1-5): "))
            if 1 <= rating <= 5:
                return rating
            else:
                print("Invalid input. Enter a rating between 1 and 5.")
        except ValueError:
            print("Invalid input. Please enter a number.")

def main():
    movies = {}  
    while True:
        display_menu()
        choice = input("Choose between (1-5): ")
        match choice:
            case "1":
                name = get_add_movie()
                
                if name not in movies:
                    movies[name] = []  
                    print(f"Movie '{name}' added successfully>>>>>  ")
                else:
                    print("Movie already exists.")
            case "2" :
                print("="*40)
                
                name = print("List of movie users Entered")
                if name:
                    for view_moives, name in movies.items():
                        print( f"Movie avaliable {view_moives}")
                    else:
                        print("no moive avaliable")

                else:
                    print("No Movies inputed yet")
            case "3":
                print("="*40)
                name = input("Enter the movie name you want to rate: ").strip()
                if name in movies:
                    rating = get_rating_movie()
                    movies[name].append(rating)
                    print(f"You Rated {name} {rating} it has been added >>>>>")
                else:
                    print("Movie not found. Please add the movie first.")
                    
            case "4":
                print("="*40)
                if movies:
                    for movie, ratings in movies.items():
                        average_rating = sum(ratings) / len(ratings) if ratings else 0
                        print(f" Average Rating of '{movie}' is  {average_rating:.2f} in Total!")
                else:
                    print("No movies available.")
         
            
            case "5":
                    print("Bye: \U0001F44B your ratings are valid...")
                    break
            case _:
                print("Invalid choice. Please choose a valid option.")

if __name__ == "__main__":
    main()
  
