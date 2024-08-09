package com.example.aymanyasin_comp304lab4_ex1

object LandmarkTypeDataSource {

    val landmarkTypes = listOf(
        LandmarkType("Buildings", R.drawable.ibuilding).apply {
            landmarks = listOf(
                Landmark("Casa Loma", R.drawable.building ),
                Landmark("Old City Hall", R.drawable.nbuilding),
                Landmark("Massey Hall", R.drawable.mbuilding),
                Landmark("St. Lawrence Hall", R.drawable.buildings ),
                Landmark("Old Fort York", R.drawable.icbuilding)
            )
        },


        LandmarkType("Museums", R.drawable.museums).apply {
            landmarks = listOf(
                Landmark("Royal Ontario Museum", R.drawable.romuseum),
                Landmark("Bata Shoe Museum", R.drawable.musum),
                Landmark("Hockey Hall of Fame", R.drawable.nmusume),
                Landmark("Aga Khan Museum", R.drawable.mmuseums),
                Landmark("Toronto Railway Museum", R.drawable.museeme)
            )


        },
        LandmarkType("Parks", R.drawable.park).apply {
            landmarks = listOf(
                Landmark("High Park", R.drawable.citypark),
                Landmark("Trinity Bellwoods Park", R.drawable.highpark),
                Landmark("Toronto Islands", R.drawable.ppark),
                Landmark("Scarborough Bluffs Park", R.drawable.hpark),
                Landmark("Centennial Park", R.drawable.opark),
            )
        },

        LandmarkType("Stadiums", R.drawable.nstadiums).apply {
            landmarks = listOf(
                Landmark("Maple Leaf Arena", R.drawable.stadiums),
                Landmark("Raptors Center", R.drawable.stadium9),
                Landmark("Blue Jays Park", R.drawable.stadium),
                Landmark("Toronto Football Stadium", R.drawable.sstadiums)
            )
        },

        LandmarkType("Historical Sites", R.drawable.ljhouse).apply {
            landmarks = listOf(
                Landmark("Mackenzie House", R.drawable.nnhouse),
                Landmark("Fort Rouillé", R.drawable.lhouse),
                Landmark("Scadding Cabin", R.drawable.nhh),
                Landmark("Museum of Inuit Art", R.drawable.mhouse),
                Landmark("Fort York Armoury", R.drawable.jhouse),

            )
        },

        LandmarkType("Attractions", R.drawable.gallery).apply {
            landmarks = listOf(
                Landmark("CN Tower", R.drawable.ic_cntowerrr),
                Landmark("Art Gallery of Ontario", R.drawable.museupainting),
                Landmark("Ripley's Aquarium of Canada", R.drawable.aquariumj),
                Landmark("Toronto Zoo", R.drawable.zoo),
                Landmark("Ontario Science Centre", R.drawable.scentre),
                Landmark("High Park", R.drawable.hpark),
                Landmark("St. Lawrence Market", R.drawable.lmarket),
            )
        }

    )

}