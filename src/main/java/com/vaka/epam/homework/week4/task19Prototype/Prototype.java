package com.vaka.epam.homework.week4.task19Prototype;

/**
 * Created by Iaroslav on 11/19/2016.
 */
//19. Паттерн  Prototype. Существует набор статей в википедии. Реализовать про -
//        цесс раздачи статей потребованию для изменения, сохраняя исходный ва-
//        риант для возможного восстановления статьи висходном виде.
interface Prototype {
    Prototype createCopy();
}
