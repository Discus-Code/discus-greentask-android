package org.discusinstitute.greentaskandroid.discus.data

class MockData() {
    val wallpapers = mutableListOf<Wallpaper>()
    val sounds = mutableListOf<Sound>()
    val tasks = mutableListOf<SustainabilityTask>()
    var currentSoundId = "fgh1"
    var mockCurrentWallpaperId = "xyz1"
    var mockCurrentTaskId = "abc1"
    var completedTasks = mutableListOf<CompletedSustainabilityTask>()

    init {
        tasks.add(
            SustainabilityTask(
                "abc1",
                "task 1: Donec tristique, nisl non dictum venenatis, felis dui fermentum urna, non facilisis enim orci vel sapien. In hac habitasse platea dictumst.",
                "did you know 1: Proin nec ex malesuada, faucibus enim eget, rhoncus augue. Duis congue eros odio, nec eleifend diam finibus non."
            )
        )
        tasks.add(
            SustainabilityTask(
                "abc2",
                "task 2: Proin a leo luctus, molestie mi blandit, rhoncus ipsum. Aliquam pharetra purus at diam porta rhoncus. Donec at sem nec nisi pulvinar eleifend sit amet non neque.",
                "did you know 2:  Cras ac arcu sapien. Sed ultricies urna et leo porttitor, elementum elementum sem cursus. Integer venenatis rhoncus urna, ut hendrerit elit imperdiet aliquet. In orci sem, vehicula id sodales ac, mattis at ipsum. "
            )
        )

        tasks.add(
            SustainabilityTask(
                "abc3",
                "task3: Proin a leo luctus, molestie mi blandit, rhoncus ipsum. Aliquam pharetra purus at diam porta rhoncus. ",
                "did you know 3:  Donec id enim a mi viverra rhoncus. Praesent eu lacus in ipsum aliquam fringilla sollicitudin a odio. In feugiat sapien sit amet justo bibendum aliquam. Phasellus et neque mi. "
            )
        )


        wallpapers.add(
            Wallpaper(
                "xyz2",
                "https://www.economist.com/sites/default/files/images/print-edition/20190914_STP005_0.jpg",
                "Planet",
                0
            )
        )
        wallpapers.add(
            Wallpaper(
                "xyz3",
                "https://placekitten.com/200/300",
                "Kitten1",
                5
            )
        )
        wallpapers.add(
            Wallpaper(
                "xyz4",
                "https://placekitten.com/400/600",
                "Kitten2",
                5
            )
        )
        wallpapers.add(
            Wallpaper(
                "xyz5",
                "https://placekitten.com/300/300",
                "Kitten3",
                5
            )
        )
        wallpapers.add(
            Wallpaper(
                "xyz6",
                "https://placekitten.com/500/500",
                "Kitten4",
                5
            )
        )
        wallpapers.add(
            Wallpaper(
                "xyz7",
                "https://placekitten.com/400/300",
                "Kitten5",
                5
            )
        )


        sounds.add(
            Sound(
                "fgh1",
                "https://elasticbeanstalk-us-east-1-562744294382.s3.amazonaws.com/408930__marisca16__baby-horse-running-001.wav",
                "Horse Running",
                0
            )
        )
        sounds.add(
            Sound(
                "fgh2",
                "https://elasticbeanstalk-us-east-1-562744294382.s3.amazonaws.com/411729__inspectorj__wind-chime-tolling-a.wav",
                "Wind Chime",
                0
            )
        )
    }

}