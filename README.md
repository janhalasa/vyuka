# Výuka programovania 2002

Zdrojové kódy pre výuku programovania.

## Java

Java programy sa nachádzajú v podadresári java.
Pre preloženie programu treba v termináli napísať

`javac NazovTriedy.java`

Tým sa vytvorí súbor rovnakého názvu s príponou ".class".
Pre spustenie preloženého súboru treba v termináli napísať

`java NazovTriedy`

### Bežné chyby

- Príkazy java aj javac je potrebné spúšťať v rovnakom adresári ako je java súbor, ktorý chceme preložiť alebo spustiť. Inak dostaneme chybu, že súbor alebo trieda neexistujú.
- Hlavná trieda programu musí mať rovnaký názov ako je názov súboru. Je nutné zachovať aj rovnakú veľkosť písmen.
- Ak prekladač píše, že "cannot find symbol", tak si na danom riadku skontrolujte, či tam nemáte preklep, alebo či premenná je deklarovaná (má typ, napríklad String, int) alebo ak používate externú triedu, či bola importovaná.
- Ak vám prekladač hlási chybu, skúste ju pochopiť, často sa z nej dá vyčítať, ako ju opraviť.
