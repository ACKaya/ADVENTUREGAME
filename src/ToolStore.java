public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super("Tool Store", player);
    }

    @Override
    public boolean onLocation() {
        while (true) {
            System.out.println("-------WELCOME TO THE STORE-------");
            System.out.println("CHOOSE A OPERATION");
            System.out.println("1-WEAPONS " +
                    "2- ARMOR " +
                    "3- EXIT ");
            int select = input.nextInt();
            while (select < 1 || select > 3) {
                System.out.println("YOU ENTERED A NOT VALID NUMBER:");
                System.out.println("PLEASE CHOOSE AGAIN");
                int select2 = input.nextInt();
            }
            switch (select) {
                case 1:
                    printWeapon();
                    break;
                case 2:
                    printArmor();
                    selectArmor();
                    break;
                case 3:
                    System.out.println("WE HOPE YOU HAVE FUN ");
                    return false;
            }
            return true;
        }
    }
    public void printWeapon(){
        System.out.println("-------WEAPON LIST-----");
        WEAPONS [] list={new GLOCK(),new SWORD(),new RIFFLE()};
        for(WEAPONS w:list){
            System.out.println("ID:"+w.getID()+" WEAPON NAME:"+w.getName()+" WEAPON DAMAGE:"+w.getDamage()+" WEAPON PRICE:"+w.getMoney());
        }
        System.out.println("CHOOSE A WEAPON:");
        int selectedweaponID= input.nextInt();
        while(selectedweaponID<1||selectedweaponID>3){
            System.out.println("YOU ENTERED A NOT VALID NUMBER");
            System.out.println("CHOOSE AGAIN:");
            selectedweaponID= input.nextInt();
        }
        WEAPONS selectedweapon=WEAPONS.getObjById(selectedweaponID);
        if(selectedweapon!=null){
            if(selectedweapon.getMoney()>this.getPlayer().getMoney()){
                System.out.println("YOU HAVE NOT ENOUGH MONEY TO BUY THIS WEAPON!");
            }
            else{
                System.out.println("YOU BOUGHT THE "+selectedweapon.getName());
                int newMoney=this.getPlayer().getMoney()-selectedweapon.getMoney();
                int newDamage=this.getPlayer().getDamage()+selectedweapon.getDamage();
                this.getPlayer().setMoney(newMoney);
                this.getPlayer().setDamage(newDamage);
                System.out.println("Your Remaining Money is: "+getPlayer().getMoney());
                System.out.println("Onceki Silah: "+this.getPlayer().getInventory().getWeapon().getName());
                this.getPlayer().getInventory().getWeapon().setName(selectedweapon.getName());
                System.out.println("Sonraki Silah:"+getPlayer().getInventory().getWeapon().getName());
            }
        }
    }
    public void printArmor(){
        System.out.println("-------ARMOR LIST-------");
        Armors [] armorlist={new LightArmor(),new MiddleArmor(),new HeavyArmor()};
        for(Armors x:armorlist){
            System.out.println("\tID:"+x.getID()+
            "\tARMOR NAME:"+x.getName()+
                    "\tARMOR DEFENCE:"+x.getDefence()+
                    "\tARMOR PRICE:"+x.getMoney());
        }
    }
    public void selectArmor(){
        System.out.println("CHOOSE A ARMOR!");
        int selectArmor= input.nextInt();
        while(selectArmor<1||selectArmor>3){
            System.out.println("YOU ENTERED NOT VALID NUMBER!!");
            System.out.println("Please Choose Again");
            selectArmor= input.nextInt();
        }
        Armors selectedArmor=Armors.getObjByID(selectArmor);
        if(selectedArmor!= null){
            if(selectedArmor.getMoney()>this.getPlayer().getMoney()){
                System.out.println("YOU HAVE NOT ENOUGH MONEY TO BUY THIS ARMOR!!");
            }
            else{
                System.out.println("YOU BOUGTH THE "+selectedArmor.getName());
            }
            int newMoney=this.getPlayer().getMoney()- selectedArmor.getMoney();
            this.getPlayer().setMoney(newMoney);
            int newDefence=this.getPlayer().getHealth()+selectedArmor.getDefence();
            this.getPlayer().setHealth(newDefence);
            System.out.println("ONCEKI ZIRHINIZ:"+this.getPlayer().getInventory().getArmor().getName());

            this.getPlayer().getInventory().getArmor().setName(selectedArmor.getName());
            System.out.println("SONRAKI ZIRHINIZ:"+this.getPlayer().getInventory().getArmor().getName());


        }

    }

}
