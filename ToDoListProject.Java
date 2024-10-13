    public class TodoListProject{
        //Maximum List you can Add (Modify it yourself)
        public static String[] model = new String[25];
        public static java.util.Scanner scanner = new java.util.Scanner(System.in);
        public static void main(String[] args){
            //Calls out the Method
            ViewShowList();
        }
        //Display To do List
        public static void ShowToList(){
            //Shows an Array of List Loop
            for(var i = 0; i < model.length; i++){
                String ToDo = model[i];
                var Nomor = i + 1;
                //If Todo Is not Empty Prints out all the To Do List
                if(ToDo != null){
                    System.out.println(Nomor + "." + ToDo);
                }
            }
            
        }
        //Add a List
        public static void AddList(String Todo){
            //Checks if the list is full
            var Isfull = true;
            for(var i = 0; i< model.length; i++){
                if(model[i] == null){
                    Isfull = false;
                    break;
                }
            }

        //if its full Resize the Array Size
        if(Isfull){
                var temp = model;
                model = new String[model.length*2];
                for(var i = 0; i < temp.length; i++){
                    model[i] = temp[i];
                }
            }

            //Add Index on Empty Array
            for(var i = 0; i < model.length; i++){
                if(model[i] == null){
                    model[i] = Todo;    
                    break;
                }
            }
        }
        //Delete a List
        public static boolean DelList(int Num){
            //if Number - 1 is more than the length of Array
            if((Num - 1) >= model.length){
                return false;
            }
            //Check if the Index is Null
            else if(model[Num - 1] == null){
                return false;
            }   
            else{
                    for(int i = 0; i < model.length; i++){
                        if(i ==(model.length - 1)){
                            model[i] = null;
                        }
                        else{
                     model[i] = model[ i + 1];   
                        }
                    }
                return true;
                }
            }


        //Data Input Method
        public static String InputData(String Input){
            System.out.print(Input + ": ");
          String Data =  scanner.nextLine();
          return Data;
        }
        public static void Input(){
            var data = InputData ("Name");
            System.out.println(data);
        }
        //Viewing added  List
        public static void ViewShowList(){
            while(true){
            ShowToList();
            System.out.println("Menu");
            System.out.println("1. Add");
            System.out.println("2. Remove");
            System.out.println("x. Exit");
    //Choosing
            var input = InputData("Choose: ");
            if(input.equals("1")){
                ViewAddedList();
            }else if(input.equals("2")){
                ViewDelList();
            }else if(input.equals("x")){
                System.out.println("Auf Wiedersehen!");
                break;
            }else{
                System.out.println("Invalid Input");
            }
            }
        }
      
        public static void ViewAddedList(){
            System.out.println("Adding List");
            var ToDo = InputData("Things To Do: (Press x to Cancel)");
            if(ToDo.equals("x")){
                //Cancel
                }else{
                    AddList(ToDo);
                }
        }

        //Viewing Deleted List
        public static void ViewDelList(){
            System.out.println("Deleting List");
            var Num = InputData("Number to Delete (Press x To Cancel)");
            if(Num.equals("x")){
                //Cancelling
            }else{
                int Number = Integer.parseInt(Num);
                boolean success = DelList(Number);
                if(!success){
                    System.out.println("Failed to Delete: "+ Num);
                }
            }
        }
    }