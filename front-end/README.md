# Front-end

This document contains information about our frontend.

## About

We use React.js to create the frontend of the application. I mean, we will use react. But currently there are no frontend. It's kind of sad.

## Funkciók működésének leírása:

Bejelentkezés az alkalmazásba 

Látogassuk meg a http://localhost:3000/oldalt. 

A felső menüben kattintsunk a Login gombra. 

  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/Login.png?raw=true "Login")
  
Kattintsunk a username felirattal jelölt mezőbe. 

Vigyük be a mezőbe például a username szöveget. 

Ekkor bemásolódik a username a username változó értékébe. 

Kattintsunk a password felirattal jelölt mezőbe. 

Vigyük be a mezőbe a password szöveget. 

Ekkor bemásolódik a password a password változó értékébe. 

Kattintsunk az Enter felirattal jelölt gombra. 

Ekkor meghívódik az AuthService osztály login(string, string) metódusa. 

  A metódus egy POST requestet küld a backend számára, amely a http://localhost:8080/ címen fut-szalad.
 
  A backend fogadja a kérést, majd BCrypt eljárással hash-eli a jelszót, mivel az adatbázisban is ilyen formában tároljuk ezt (biztonsági okoból). 

  Amennyiben megtalálható az adott felhasználónév-jelszó párossal tarkított adat a felhasználók között, jelzi ezt (vagy ennek ellenkezőjét) a frontend számára, amely kiértékeli a választ. 

    Amennyiben helyesek voltak az adatok, a felhasználót bejelentkezetté teszi és továbbítja a http://localhost:3000/receipts címre. 
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/register.png?raw=true "Register")

    Amennyiben hibásak az adatok, jelzi ezt a felhasználó számára. 
    
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/Wrc.png?raw=true "wrong login credentials alert")

Az elérhető nyugták kilistázódnak. 
  
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/ListReceipt.png?raw=true "Receipt Listing")
Kattintsunk a fenti sávon az Add Receipt gombra, ha további nyugtát szeretnénk létrehozni.
  
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/AddReceipt.png?raw=true "Add Receipt")
  
  Kattintsunk a Name of the receipt felirat melletti mezőbe. 

  Vigyük be a mezőbe például a PéntekEstiBuli szöveget. 

  Ekkor bemásolódik a PéntekEstiBuli a name változó értékébe. 

  Kattintsunk a Price of the receipt felirat melletti mezőbe 

  Vigyük be a mezőbe például a 10000 számot 

  Ekkor bemásolódik a 10000 a price változó értékébe. 

  Kattintsunk az Add felirattal jelölt gombra. 
 
 ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/SuccAddReceipt.png?raw=true "Added Receipt")

Kattintsunk a fenti sávon az Items gombra, hogy megjelenjenek a nyugtákhoz adható itemek.
  
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/ItemList.png?raw=true "Item listing")

Kattintsunk a fenti sávon az Add Items gombra, ha további itemet szeretnénk hozzáadni. 
  
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/AddItem.png?raw=true "Add Items")


  Kattintsunk a Name of the item felirat melletti mezőbe. 

  Vigyük be a mezőbe például a LaFieste Édes Élmény szöveget. 

  Ekkor bemásolódik a LaFieste Édes Élmény az name változó értékébe. 

  Kattintsunk a Price of the item felirat melletti mezőbe 

  Vigyük be a mezőbe például a 10000 számot 

  Ekkor bemásolódik a 10000 a price változó értékébe. 

  Kattintsunk a Currency felirat melletti mezőbe 

  A legördülő lehetőségek közül, válasszuk ki, milyen valutával legyen az ár eltárolva. 

  Ekkor bemásolódik a kiválasztott valuta a currency_type változó értékébe. 

  Kattintsunk az Add felirattal jelölt gombra. 
  
  Ha a bevitt adatok megfelelnek az elvárásoknak, sikeresen hozzáadtunk egy újitemet.
  
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/SuccAddItem.png?raw=true "Successfulyy Added Item")
  
  Ha a bevitt adatokkal valami nem stimmel, hibát jelez a felület.
  
  ![Login](https://github.com/gonczmisi/FairShare/blob/dev/front-end/fairshare/src/WrongItemAdd.png?raw=true "Item was not added")

 

 

 

## A használat módja 

Ahhoz, hogy a programot használhassuk, az alábbi lépéseket kell megtennünk: 

Töltsük le a forrásállományokat innen, a Github-ról. Ezt két módon is megtehetjük: 

Jobb oldalon felül kattintsunk a Download, a letöltés után pedig tömörítsük ki. 

Ha a számítógépünkra van Git telepítve, akkor parancssorban futtassuk a git clone https://github.com/gonczmisi/FairShare parancsot. 

A létrejött FairShare mappát nyissuk meg NetBeans segítségével. 

Clean and Build után futassuk (Run). 

A Fairshare mappában található Front-end almappát nyissuk meg Visual Studio Code segítségével és nyissunk terminált. 

npm install 

npm audit fix (opcionális) 

npm start 

Az oldalt elérhetjük, ha a böngészőbe beírjuk a http://localhost:3000 címet. 

 
