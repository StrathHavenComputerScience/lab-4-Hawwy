public class Lab4
{
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }
  
  public static void completeBars()
  {
    while (Robot.frontIsClear())
    {
        complete1Bar();
    }
    complete1Bar();
  }
  //precondition: Only the top of the bars are shown and made. 
  //postcondition: All of the bars are now shown and made. 
  public static void complete1Bar()
  {
    Robot.turnLeft();
    while (!Robot.onDark())
        {
            Robot.makeDark();
            Robot.move();
        }
    turnAround();
    while (Robot.frontIsClear())
    {
        Robot.move();
    }
    Robot.turnLeft();
    if (Robot.frontIsClear())
    {
        Robot.move();
    }
  }
  //precondition: One bar only has the top shown and made. 
  //postcondition: The rest of the is completed and shown. 
  public static void testCompleteBars1()
  {
    Robot.load("bars1.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void testCompleteBars2()
  {
    Robot.load("bars2.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void combinePiles()
  {
    while (checkIfStacked())
    {
        moveOneDark();
    }
  }
  //precondition: Part of the pile is not stacked. 
  //postcondition: All blocks on the pile are stacked.
  public static void moveOneDark()
  {
    if (Robot.onDark())
    {
        Robot.makeLight();
        turnRight();
        Robot.move();
        if (Robot.onDark())
        {
            Robot.turnLeft();
            while (Robot.onDark())
            {
                Robot.move();
            }
            Robot.makeDark();
        }
        else
        {
            Robot.turnLeft();
            Robot.makeDark();
        }
    }
    turnAround();
    while (Robot.frontIsClear())
    {
        Robot.move();
    }
    turnRight();
    Robot.move();
    turnRight();
    goToNextSquare();
  }
  //precondition: One block is not stacked. 
  //postcondition: The block is now stacked. 
  public static void goToNextSquare()
  {
    while (!Robot.onDark())
    {
        if (Robot.frontIsClear())
        {
            Robot.move();
        }
        else
        {
            turnAround();
            while (Robot.frontIsClear())
            {
                Robot.move();
            }
            Robot.turnLeft();
            Robot.move();
            Robot.turnLeft();
         }
    }
  }
  //precondition: The Robot is on the wrong square.
  //postcondition: The Robot moves to the correct square.
  public static boolean checkIfStacked()
  {
      Robot.turnLeft();
      if (Robot.frontIsClear())
      {
        turnRight();
        return false;
      }
      else 
      {
        turnRight();
        return true;
      }
  }
  
  public static void testCombinePiles1()
  {
    Robot.load("piles1.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void testCombinePiles2()
  {
    Robot.load("piles2.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void connectDots()
  {
    while (checkAllPossibilities())
    {
        moveOneSquare();
    }
  }
  //precondition: The dots are not connected. 
  //postcondition: The dots are now connected.
  public static void moveOneSquare()
  {
    if (checkForward())
        {
            Robot.move();
            Robot.makeDark();
            Robot.move();
        }
      else
        {
            if (checkLeft())
            {
                Robot.turnLeft();
                Robot.move();
                Robot.makeDark();
                Robot.move();
            }
            else
            {
                if (checkRight())
                {
                    turnRight();
                    Robot.move();
                    Robot.makeDark();
                    Robot.move();
                }
            }
        }
  }
  //precondition: The Robot is one one dot.
  //postcondition: The Robot moves to the next dot. 
  public static boolean checkAllPossibilities()
  {
      if (checkForward())
        {
            return true;
        }
      else
        {
            if (checkLeft())
            {
                return true;
            }
            else
            {
                if (checkRight())
                {
                    return true;
                }
                else
                {
                    return false;
                }
            }
        }
  }
  
  public static boolean checkForward()
  {
    Robot.move();
    Robot.move();
    if (Robot.onDark())
    {
        turnAround();
        Robot.move();
        Robot.move();
        turnAround();
        return true;
    }
    else
    {
        turnAround();
        Robot.move();
        Robot.move();
        turnAround();
        return false;
    }
  }
  
  public static boolean checkLeft()
  {
    Robot.turnLeft();
    Robot.move();
    Robot.move();
    if (Robot.onDark())
    {
        turnAround();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        return true;
    }
    else
    {
        turnAround();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        return false;
    }
  }
  
  public static boolean checkRight()
  {
    turnRight();
    Robot.move();
    Robot.move();
    if (Robot.onDark())
    {
        turnAround();
        Robot.move();
        Robot.move();
        turnRight();
        return true;
    }
    else
    {
        turnAround();
        Robot.move();
        Robot.move();
        turnRight();
        return false;
    }
  }
  
  public static void testConnectDots1()
  {
    Robot.load("connect1.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  
  public static void testConnectDots2()
  {
    Robot.load("connect2.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
}
