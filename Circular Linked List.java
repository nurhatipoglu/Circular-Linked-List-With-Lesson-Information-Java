package Odevler;

import java.util.Scanner;

/**
 * <h1>Dairesel Çift ve Tek Yönlü Bağlı Liste İşlemleri</h1>
 * Bir tane ana liste olan çift yönlü bir liste var. Listeye derslere ekleme, silme,
 * görüntüleme işlemleri gerçekleşiyor.
 * <p>
 * Her somestr kendi somestr larıyla dairesel bağlanmış durumdadır.Aynı somestr da olanlar birbirine
 * tek yönlü bağlı liste ile bağlanmıştır. Dairesel olması için de son başa bağlanmıştır.
 * Bu 8 somestr için de yapılmıştır.8 somestr da aynı somestr bilgisine ait derslerle dairesel şekilde bağlıdır.
 * Dairesel olarak bağlı olan aynı semestr daki derslerin bilgileri listelenmektedir.
 * <p>
 * <b>Note:</b> Liste ders isimlerini, ders kodlarını, sömestr bilgilerini, dersin kredisi,
 * dersin kontenjanı ile ilgili değişkenleri içermektedir.
 *
 * @author Nur Hatipoğlu
 * @version 1.0
 * @since 2014-03-31
 */
public class CiftYonluBagliListe {
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int secim=-1;
        Liste2 dersler = new Liste2();
        while(secim !=0){
            System.out.println("1-Ders Ekle\n2-Dersleri Listele\n3-Ders Sil\n4-Somestrları Bagla\n0-Cikis");
            System.out.println("Yapmak istediğiniz işlemi seçiniz:");
            secim=scan.nextInt();
            switch(secim){
                case 1:
                    scan.nextLine();
                    System.out.println("Ders ismi giriniz:"); String dersIsmi= scan.nextLine();
                    System.out.println("Dersin kodunu giriniz(int giriniz):"); int dersKod= scan.nextInt();
                    System.out.println("Dersin somestrını giriniz:"); int somestr= scan.nextInt();
                    System.out.println("Dersin kredisini giriniz:"); int kredi= scan.nextInt();
                    System.out.println("Dersin kontenjanını giriniz:"); int kontenjan= scan.nextInt();
                    dersler.add2(dersIsmi, dersKod, somestr, kredi, kontenjan);
                    System.out.println("Ekleme tamamlandı.");
                    break;
                case 2:
                    dersler.listele2();
                    break;
                case 3:
                    System.out.println("Silmek istediğiniz dersin kodunu giriniz:");
                    int kod = scan.nextInt();
                    dersler.remove2(kod);
                    System.out.println("Silme işlemi gerçekleştirildi.");
                    break;
                case 4:
                    System.out.println("Hangi somesterleri baglamak istediginizi giriniz:1/2/3/4/5/6/7/8");
                    int somestrsec= scan.nextInt();
                    switch(somestrsec){
                        case 1:
                            dersler.somestrBagla1();
                            System.out.println("1.somestrlar circular baglandi.");
                            break;
                        case 2:
                            dersler.somestrBagla2();
                            System.out.println("2.somestrlar circular baglandi.");
                            break;
                        case 3:
                            dersler.somestrBagla3();
                            System.out.println("3.somestrlar circular baglandi.");
                            break;
                        case 4:
                            dersler.somestrBagla4();
                            System.out.println("4.somestrlar circular baglandi.");
                            break;
                        case 5:
                            dersler.somestrBagla5();
                            System.out.println("5.somestrlar circular baglandi.");
                            break;
                        case 6:
                            dersler.somestrBagla6();
                            System.out.println("6.somestrlar circular baglandi.");
                            break;
                        case 7:
                            dersler.somestrBagla7();
                            System.out.println("7.somestrlar circular baglandi.");
                            break;
                        case 8:
                            dersler.somestrBagla8();
                            System.out.println("8.somestrlar circular baglandi.");
                            break;
                    }
                case 0:
                    System.out.println("Cikis yapildi.");
                    break;
            }
        }
    }
}

/**
 *Bu sınıf bağlı liste işlemlerinde kullanılmak için oluşturulmuştur.
 */
class Liste2{
    Ders2 ilk=null, son=null;
    Ders2 ilk1,son1,ilk2,son2,ilk3,son3,ilk4,son4,ilk5,son5,ilk6,son6,ilk7,son7,ilk8,son8=null;
    /**
     * Metot, kullanıcı dersin belirtilen parametre bilgilerini girdiğinde bu node bağlı listenin sonuna eklenir.
     * @param dersIsmi add metotunun ilk parametresidir.
     * @param dersKod add metotunun ikinci parametresidir.
     * @param somestr add metotunun üçüncü parametresidir.
     * @param kredi add metotunun dördüncü parametresidir.
     * @param kontenjan add metotunun beşinci parametresidir.
     */
    public void add2(String dersIsmi, int dersKod, int somestr, int kredi, int kontenjan){
        Ders2 ders = new Ders2(dersIsmi,dersKod,somestr,kredi,kontenjan);
        if(ilk==null){
            //liste bos
            //eger null ise listeye hiç eleman eklenmemiş demektir.
            //listede ilk ve tek olan yeni oluşturulmuş ders nesnesidir.
            //ilk ve son da listedeki tek eleman olan dersi gostermelidir.
            ilk=ders;
            son=ders;
        }
        else{
            //liste dolu
            //eger eklenen ilk kayıt değilse, kayıt son un sonuna eklenir.
            son.next=ders; //son dedigimizin next i normalde null dı cunku sonrası yoktu.Simdi son un next ini yeni olusturdugum ders yaptım.
            //son dan sonraki ders ise sonuncu da ders dir.
            ders.prev =son;
            son= ders; //son denilen; node a yani ekledigim yeni eleman olan ders e isaret etmeli.
        }
    }

    //Bu metot bağlı listede bulunan derslerin bilgilerini listeler.
    public void  listele2(){
        int elemanSayisi=0;
        Ders2 gecici = ilk;//gecici tum node ların uzerinde gezecek.Listeyi bastan yazdırmaya baslıycaz o yuzden ilk den basla.
        //gecici nin isaret ettigi null olmadıgı surece yeni bir elemana gidebiliriz.
        while(gecici != null){
            //eger gecici null a eşit değilse yani liste boş değilse listeyi listelesin.
            System.out.println(gecici.dersIsmi+" "+gecici.dersKod+" "+gecici.somestr+" "+gecici.kredi+" "+gecici.kontenjan);
            gecici = gecici.next; //gecici yi ilertletmemiz gerekiyor ki bir sonraki node u(elemanı) isaret etsin.
            elemanSayisi++;
        }
        System.out.println("Listelendi.");
        System.out.println("Liste Boyutu:"+elemanSayisi);
    }

    /**
     * Bu metot kullanıcının kodunu girdiği dersin bağlı listeden silme işlevini gerçekleştirir.
     * @param dersKod remove metotunun ilk parametresidir.
     */
    public void remove2(int dersKod){
        Ders2 gecici = ilk;
        while(gecici != null){
            if(gecici.dersKod == dersKod){
                break;
            }
            gecici = gecici.next;
        }
        if(gecici==null){
            System.out.println("Aranılan Kayıt Bulunamadı");
        }
        else{
            if(gecici==ilk){
                if(ilk == son){
                    //silinecek ilk ve tek elemansa
                    ilk=null;
                    son=null;
                }
                else{
                    //silinecek ilk kayıtsa
                    ilk = gecici.next;
                    ilk.prev =null; //ilk elemanı cikarmıs olduk.
                }
            }
            else{
                //eger ilk eleman degilse
                if(gecici==son){
                    //silinecek eleman sondaysa
                    son = gecici.prev; //son gecicinin prev ini gösterir.
                    son.next =null;// boylece sonuncu elemanı cikarmis olduk
                }
                else{
                    //eger silinecek eleman ortadaysa 1-2-3-4.
                    gecici.prev.next = gecici.next;
                    gecici.next.prev = gecici.prev;
                }
            }
        }
    }

    /**
     * somestrBagla adlı metotlar somester lar arası linki tutar 1.,2.,3....8. somester linki şeklinde 8 tane link vardır.
     * Sonrasında her somestr a ait oluşturulan dairesel bağlı listenin ders bilgileri konsola yazdırılır.
     */
    public void somestrBagla1() {
        Ders2 gecici =ilk,ilksomestr=null;
        Ders2 yenigecici =null;
        int sayac=0,size=0;
        while(gecici != null){
            if(gecici.somestr == 1){
                size++;
                if(ilk1 ==null){
                    yenigecici=gecici;
                    ilksomestr =gecici;
                    ilk1=yenigecici;
                    son1=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son1.next1= yenigecici;
                    son1= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son1.next1 = ilk1;

        System.out.println("NEXT1 İLE GEZİNELİM");
        yenigecici=ilk1;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next1;
        }

/*
        Ders2 gecici = ilk, ilksomestr = null;
        Ders2 yenigecici = null;
        int sayac = 0, size = 0, i = 0;
        while (gecici != null) {
            if (gecici.somestr == (i + 1)) {
                size++;
                if (ilkler[i] == null) {
                    yenigecici = gecici;
                    ilksomestr = gecici;
                    ilkler[i] = yenigecici;
                    sonlar[i] = yenigecici;
                    gecici = gecici.next;
                } else {
                    yenigecici = gecici;
                    sonlar[i].nexts[i] = yenigecici;
                    sonlar[i] = yenigecici;
                    gecici = gecici.next;
                }
            } else {
                gecici = gecici.next;
            }
        }
        sonlar[i].nexts[i] = ilkler[i];

        System.out.println("NEXT1 İLE GEZİNELİM");
        yenigecici = ilkler[i];
        for (int j = 0; j < size; j++) {
            System.out.println(yenigecici.dersIsmi + " " + yenigecici.dersKod + " " + yenigecici.somestr + " " + yenigecici.kredi + " " + yenigecici.kontenjan);
            yenigecici = yenigecici.nexts[i];
        }*/
    }
    public void somestrBagla2() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 2){
                size++;
                if(ilk2 ==null){
                    yenigecici=gecici;
                    ilk2=yenigecici;
                    son2=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son2.next2= yenigecici;
                    son2= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son2.next2 = ilk2;

        System.out.println("NEXT2 İLE GEZİNELİM");
        yenigecici=ilk2;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next2;
        }
    }
    public void somestrBagla3() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 3){
                size++;
                if(ilk3 ==null){
                    yenigecici=gecici;
                    ilk3=yenigecici;
                    son3=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son3.next3= yenigecici;
                    son3= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son3.next3 = ilk3;

        System.out.println("NEXT3 İLE GEZİNELİM");
        yenigecici=ilk3;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next3;
        }
    }
    public void somestrBagla4() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 4){
                size++;
                if(ilk4 ==null){
                    yenigecici=gecici;
                    ilk4=yenigecici;
                    son4=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son4.next4= yenigecici;
                    son4= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son4.next4 = ilk4;

        System.out.println("NEXT4 İLE GEZİNELİM");
        yenigecici=ilk4;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next4;
        }
    }
    public void somestrBagla5() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 5){
                size++;
                if(ilk5 ==null){
                    yenigecici=gecici;
                    ilk5=yenigecici;
                    son5=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son5.next5= yenigecici;
                    son5= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son5.next5 = ilk5;

        System.out.println("NEXT3 İLE GEZİNELİM");
        yenigecici=ilk5;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next5;
        }
    }
    public void somestrBagla6() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 6){
                size++;
                if(ilk6 ==null){
                    yenigecici=gecici;
                    ilk6=yenigecici;
                    son6=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son6.next6= yenigecici;
                    son6= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son6.next6 = ilk6;

        System.out.println("NEXT6 İLE GEZİNELİM");
        yenigecici=ilk6;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next6;
        }
    }
    public void somestrBagla7() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 7){
                size++;
                if(ilk7 ==null){
                    yenigecici=gecici;
                    ilk7=yenigecici;
                    son7=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son7.next7= yenigecici;
                    son7= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son7.next7 = ilk7;

        System.out.println("NEXT7 İLE GEZİNELİM");
        yenigecici=ilk7;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next7;
        }
    }
    public void somestrBagla8() {
        Ders2 gecici =ilk;
        Ders2 yenigecici =null;
        int size=0;
        while(gecici != null){
            if(gecici.somestr == 8){
                size++;
                if(ilk8 ==null){
                    yenigecici=gecici;
                    ilk8=yenigecici;
                    son8=yenigecici;
                    gecici= gecici.next;
                }else{
                    yenigecici = gecici;
                    son8.next8= yenigecici;
                    son8= yenigecici;
                    gecici = gecici.next;
                }
            }
            else{
                gecici=gecici.next;
            }
        }
        son8.next8 = ilk8;

        System.out.println("NEXT8 İLE GEZİNELİM");
        yenigecici=ilk8;
        for(int i=0;i<size;i++){
            System.out.println(yenigecici.dersIsmi+" "+yenigecici.dersKod+" "+yenigecici.somestr+" "+yenigecici.kredi+" "+yenigecici.kontenjan);
            yenigecici=yenigecici.next8;
        }
    }
}

/**
 *Bu sınıf bağlı listenin node unu oluşturmak için kullanılır.
 */
class Ders2{
    //node un içindekiler
    String dersIsmi;
    int dersKod,somestr,kredi,kontenjan;
    Ders2 next,prev;    //dersin bir sonraki dersi tutması için node olacak.Bir sonraki dersi tutan node tanımladık.
    Ders2 next1,next2,next3,next4,next5,next6,next7,next8;
    /**
     * Kurucu metot girilen bilgileri bu sınıftaki değişkenlere atar.
     * @param dersIsmi Ders kurucu metotunun ilk parametresidir.
     * @param dersKod Ders kurucu metotunun ikinci parametresidir.
     * @param somestr Ders kurucu metotunun üçüncü parametresidir.
     * @param kredi Ders kurucu metotunun dördüncü parametresidir.
     * @param kontenjan Ders kurucu metotunun beşinci parametresidir.
     */
    public Ders2(String dersIsmi, int dersKod, int somestr, int kredi, int kontenjan) {
        this.dersIsmi = dersIsmi;
        this.dersKod = dersKod;
        this.somestr = somestr;
        this.kredi = kredi;
        this.kontenjan = kontenjan;
        this.next = null;//yeni eleman olusturdugumuzda sirada baska eleman olmadıgını varsayıyoruz.
        this.prev = null;
        this.next1 = null;this.next2 = null;this.next3 = null;this.next4 = null;this.next5 = null;this.next6 = null;this.next7 = null;this.next8 = null;
    }
}
