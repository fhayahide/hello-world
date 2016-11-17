import java.util.Random;
import java.util.Scanner;

public class Gamev2{
	public static void main(String[] args) {
		Method m = new Method();

		m.getName();
		m.setHpMp();
		m.batttle();
		m.victory();
	}
}


class Data{
	static String name=null;
	static int hp=0;
	static int hp2=0;
	static int mp=0;
	static int mpN=0;
	static int attack=0;
	static int mttack=0;
	static int damage=0;
	static int dDamage=0;
	static int d=0;
	static int mdamage=0;
	static int recovery=0;
	static int consumptionD=50;
	static int consumptionC=30;
	static int consumptionS=10;
	static int hpC=500;
	static int hpCD=350;
	static int mpR=150;
	static int ranH=2000;
	static int ranHa=1000;
	static int ranHa2=1000;
	static int ranM=250;
	static int ranMa=100;
	static int ranA=500;
	static int ranAa=100;
	static int ranAab=150;
	static int ranAac=200;
	static int ranMdD=400;
	static int ranMdDa=500;
	static int ranMdC=500;
	static int ranMdCa=250;
	static int ranMdS=450;
	static int ranMdSa=150;
	static int ranRD=300;
	static int ranRDa=400;
	static int ranRC=400;
	static int ranRCa=150;
	static int ranRS=350;
	static int ranRSa=50;
	static int ranCmd=3;
	static int rc=0;
	static int c=0;
}

class Method{
	Data d = new Data();
	public void getName(){
		System.out.println("名前を入力してね");
		d.name = new Scanner(System.in).nextLine();
	}
	public void setHpMp(){
		d.hp = new Random().nextInt(d.ranH)+d.ranHa;
		d.mp = new Random().nextInt(d.ranM)+d.ranMa;
		d.hp2 = new Random().nextInt(d.ranH)+d.ranHa2;
	}

	public void cmd(){
		vcmd();
		d.c = new Scanner(System.in).nextInt();
		switch (d.c) {
			case 1:
			d.attack = new Random().nextInt(d.ranA);
			d.hp2 = d.hp2 - d.attack;
			System.out.println(d.name+"の攻撃"+d.attack+"のダメージ！");
			System.out.println("スライムの残りHp:"+d.hp2);
			break;

			case 2:
			if(d.mp > d.consumptionD){
				d.mttack = new Random().nextInt(d.ranMdD)+d.ranMdDa;
				d.hp2 = d.hp2 - d.mttack;
				d.mp = d.mp - d.consumptionD;
				System.out.println(d.name+"の攻撃魔法(大)！");
				System.out.println("スライムに"+d.mttack+"のダメージ！");
				System.out.println("スライムの残りHp:"+d.hp2);
				System.out.println(d.name+"の残りMp:"+d.mp);
			}else if (d.mp > d.consumptionC) {
				d.mttack = new Random().nextInt(d.ranMdC)+d.ranMdCa;
				d.hp2 = d.hp2 - d.mttack;
				d.mp = d.mp - d.consumptionC;
				System.out.println(d.name+"の攻撃魔法(中)！");
				System.out.println("スライムに"+d.mttack+"のダメージ！");
				System.out.println("スライムの残りHp:"+d.hp2);
				System.out.println(d.name+"の残りMp:"+d.mp);

			}else if (d.mp > d.consumptionS){
				d.mttack = new Random().nextInt(d.ranMdS)+d.ranMdSa;
				d.hp2 = d.hp2 - d.mttack;
				d.mp = d.mp - d.consumptionS;
				System.out.println(d.name+"の攻撃魔法(小)！");
				System.out.println("スライムに"+d.mttack+"のダメージ！");
				System.out.println("スライムの残りHp:"+d.hp2);
				System.out.println(d.name+"の残りMp:"+d.mp);
			}else{
				System.out.println("残念Mpが足りないよ...");
			}

			break;

			case 3:
			if (d.mp > d.consumptionD) {
				d.recovery = new Random().nextInt(d.ranRD)+d.ranRDa;
				d.hp = d.hp + d.recovery;
				d.mp = d.mp - d.consumptionD;
				System.out.println(d.name+"の回復魔法(大)！");
				System.out.println(d.name+"は"+d.recovery+"回復した！");
				System.out.println(d.name+"の残りHp:"+d.hp);
				System.out.println(d.name+"の残りMp:"+d.mp);
			}else if (d.mp > d.consumptionC) {
				d.recovery = new Random().nextInt(d.ranRC)+d.ranRCa;
				d.hp = d.hp + d.recovery;
				d.mp = d.mp - d.consumptionC;
				System.out.println(d.name+"の回復魔法(中)！");
				System.out.println(d.name+"は"+d.recovery+"回復した！");
				System.out.println(d.name+"の残りHp:"+d.hp);
				System.out.println(d.name+"の残りMp:"+d.mp);
			}else if (d.mp > d.consumptionS) {
				d.recovery = new Random().nextInt(d.ranRS)+d.ranRSa;
				d.hp = d.hp + d.recovery;
				d.mp = d.mp - d.consumptionS;
				System.out.println(d.name+"の回復魔法(小)！");
				System.out.println(d.name+"は"+d.recovery+"回復した！");
				System.out.println(d.name+"の残りHp:"+d.hp);
				System.out.println(d.name+"の残りMp:"+d.mp);
			}else{
				System.out.println("残念Mpが足りないよ...");
			}

			break;

			case 4:
			if (d.hp >= d.hpC) {
				d.hp = d.hp - d.hpCD;
				d.mp = d.mp + d.mpR;
				System.out.println(d.name+"は"+"Hp:"+d.hpCD+"を犠牲に");
				System.out.println("Mp:"+d.mpR+"回復した！");
				System.out.println("残りMp:"+d.mp);
			}else{
				System.out.println("残念Hpが足りないよ...");
			}

			break;

			case 5:
			if(d.mp > d.consumptionD){
				d.damage = new Random().nextInt(d.ranMdC)+d.ranMdCa;
				d.hp2 = d.hp2 - d.damage;
				d.dDamage = d.damage/2;
				d.hp = d.hp + d.dDamage;
				d.mp = d.mp - d.consumptionD;
				System.out.println(d.name+"のドレイン！");
				System.out.println("スライムに"+d.damage+"のダメージ！");
				System.out.println(d.name+"は"+d.dDamage+"回復した！");
				System.out.println(d.name+"の残りHp:"+d.hp);
				System.out.println(d.name+"の残りMp:"+d.mp);
				System.out.println("スライムの残りHp:"+d.hp2);
			}else{
				System.out.println("残念Mpが足りないよ");
			}
			break;

			case 999:
			System.out.println("1.攻撃は通常攻撃をします。\nMpは消費しません。\n");
			System.out.println("2.攻撃魔法は魔法で攻撃します。\n残りMpによって(50,30,10)消費し、威力(大,中,小)を発揮します\n");
			System.out.println("3.回復魔法は魔法で回復します。\n残りMpによって(50,30,10)消費し、回復力(大,中,小)を発揮します\n");
			System.out.println("4.命を魔力にはHpを代償にMpを回復します。\n残りHp500以上で発動でき、Hpを350消費し、Mpを150回復します。\n");
			System.out.println("5.ドレインは相手に攻撃(Mpを50消費)し、与えたダメージの半分を回復します。\n");

			break;
		}
	}

	public void attackE(){
		d.rc = new Random().nextInt(d.ranCmd)+1;
		switch (d.rc) {
			case 1:
			d.d = new Random().nextInt(d.ranA)+d.ranAa;
			d.hp = d.hp - d.d;
			System.out.println("スライムの攻撃"+d.d+"のダメージ！");
			System.out.println(d.name+"残りHp:"+d.hp);
			break;

			case 2:
			d.d = new Random().nextInt(d.ranA)+d.ranAab;
			d.hp = d.hp - d.d;
			System.out.println("スライムの攻撃"+d.d+"のダメージ！");
			System.out.println(d.name+"残りHp:"+d.hp);
			break;

			case 3:
			d.d = new Random().nextInt(d.ranA)+d.ranAac;
			d.hp = d.hp - d.d;
			System.out.println("スライムの攻撃"+d.d+"のダメージ！");
			System.out.println(d.name+"残りHp:"+d.hp);
			break;
		}
	}

	public void batttle(){
		while(d.hp >= 0 && d.hp2 >=0){
			if(d.hp >= 0) {
				cmd();
			}else if(d.hp <= 0){}
			if(d.hp2 >= 0){
				if(d.c != 999){
					attackE();
				}
			}else if(d.hp2 <= 0){}
		}
	}

	public void victory(){
		if (d.hp2 <= 0) {
			System.out.println(d.name+"の勝利！");
		}else if(d.hp <= 0){
			System.out.println("スライムの勝利！");
		}else{}
	}

	public void sleep(){
		try{
			Thread.sleep(900);
		}catch(InterruptedException e){}
	}

	public void vcmd(){
		System.out.println("  ┏━━━━━┓┏━━━━┓");
		System.out.println("  ┃めいれい. ┃┃"+d.name+"┃");
		System.out.println("  ┃  させろ  ┃┠────┃");
		System.out.println("  ┗━━━━━┛┃H:"+d.hp+"  ┃");
		System.out.println("                ┃M:"+d.mp+"   ┃");
		System.out.println("                ┗━━━━┛");
		System.out.println();
		System.out.println("            人");
		System.out.println("         (  ﾟーﾟ)");
		System.out.println("          ￣￣￣");
		System.out.println("┏━━━━━━━━━━━━┓┏━━━━━━━━━━━━━┓ ");
		System.out.println("┃  "+d.name+"              ┃┃スライム 1匹"+" Hp:"+d.hp2+"      ┃");//2+14
		System.out.println("┠────────────┨┗━━━━━━━━━━━━━┛ ");
		System.out.println("┃  1攻撃     4命を魔力に ┃");
		System.out.println("┃  2攻撃魔法 5ドレイン   ┃");
		System.out.println("┃  3回復魔法 999操作説明 ┃ ");
		System.out.println("┗━━━━━━━━━━━━┛");
	}
}