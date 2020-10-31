package com.example.divergences

class Game {
    var id: String? = null
    var cap1_Opcion1: String? = null
    var cap1_Opcion2: String? = null
    var cap1_Opcion3: String? = null
    var cap2_Opcion1: String? = null
    var cap2_Opcion2: String? = null
    var cap2_Opcion3: String? = null

    constructor() {}
    constructor(
        id: String?,
        Cap1_Opcion1: String?,
        Cap1_Opcion2: String?,
        Cap1_Opcion3: String?,
        Cap2_Opcion1: String?,
        Cap2_Opcion2: String?,
        Cap2_Opcion3: String?
    ) {
        this.id = id
        cap1_Opcion1 = Cap1_Opcion1
        cap1_Opcion2 = Cap1_Opcion2
        cap1_Opcion3 = Cap1_Opcion3
        cap2_Opcion1 = Cap2_Opcion1
        cap2_Opcion2 = Cap2_Opcion2
        cap2_Opcion3 = Cap2_Opcion3
    }
}
