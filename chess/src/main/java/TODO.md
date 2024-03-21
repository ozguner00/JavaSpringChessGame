1. Tüm taşlar için x2 ve y2 de kendi taşı var mı diye bak.(piece class)
2. Tüm taşlar için x == x2 ve y == y2 kontrolü yap ( hareket etmiş mi) ( piece)
3. AT : x2-x + y2-y karesi 5 olacak. --- önündeki taş kontrolü yok.
2. FİL : x2-x == y2-y ----- x2 > x 1 arttır x2 < x 1 azalt ( + ve - hareket etmek zorunda (x,y birlikye))
3. KALE : x == x2 veya y == y2 olacak (ikisi aynı ayna kontrolü yukarıda yapılmış gelecek.)
4. KAlE : x2 > x ise y aynı kalıp tek tek karet kontrolü
5. VEZİR : kale + film 
6. ŞAH : x2-x ve y2 - y karesi 2 den büyük olamaz ( karesi olmasına dikkat)
7. 
7. PiYON : x2 ve y2 den farklı renk taş gelirse :
8. PİYON : x2 ve y2 null gelirse : 
9. PİYON : x == 1 || x == 6 ( 2 renk için de geçerli sebebi ise 6. yatayda 2 hamle yaparsa tahtayı aşar ve hata alır)
10. PİYON : renk kontrolü yap ( geriye gitmesini engelle.)
11. PİYON TERFİ ve PİYON GEÇERKEN ALMA : ( LATER)