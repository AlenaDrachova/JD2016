package by.it.sereda.project.java;


public enum Action {
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage="/signup.jsp";
            this.okPage ="/login.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage="/login.jsp";
            this.okPage ="/main.jsp";
        }
    },
    PROFILE {
        {
            this.command = new CommandProfile();
            this.inPage="/profile.jsp";
            this.okPage ="/login.jsp";
        }
    },
    CREATEAD {
        {
            this.command = new CommandCreateAd();
            this.inPage="/createad.jsp";
            this.okPage ="/";
        }
    },
    ERROR {
        {
            //это не требуется, т.к. и так стоит в инициализации
            //this.command = new CommandError();
            //String inPage="/error.jsp";
            //String okPage ="/error.jsp";
                    }
    };

    //инициализация полей по умолчанию
    protected ActionCommand command=new CommandError();
    public String inPage="/error.jsp";
    public String okPage ="/error.jsp";

    public ActionCommand getCurrentCommand() {
        return command;
    }

    public static final String msgError="msg_error";
    public static final String msgMessage="message";

}