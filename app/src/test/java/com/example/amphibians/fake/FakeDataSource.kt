package com.example.amphibians.fake

import com.example.amphibians.model.Amphibian

object FakeDataSource {
    val amphibianList = listOf(
        Amphibian(
            name = "American Bullfrog",
            type = "Frog",
            description = "The American bullfrog is a large species of frog native to North America.",
            imgSrc = "https://example.com/bullfrog.jpg"
        ),
        Amphibian(
            name = "Axolotl",
            type = "Salamander",
            description = "The axolotl is a neotenic salamander, known for its ability to regenerate limbs.",
            imgSrc = "https://example.com/axolotl.jpg"
        ),
        Amphibian(
            name = "Dart Frog",
            type = "Frog",
            description = "Dart frogs are known for their brightly colored bodies and toxic skin.",
            imgSrc = "https://example.com/dartfrog.jpg"
        ),
        Amphibian(
            name = "Eastern Newt",
            type = "Newt",
            description = "The eastern newt is a common salamander of eastern North America.",
            imgSrc = "https://example.com/easternnewt.jpg"
        ),
        Amphibian(
            name = "Fire Salamander",
            type = "Salamander",
            description = "The fire salamander is a brightly colored amphibian native to Europe.",
            imgSrc = "https://example.com/firesalamander.jpg"
        )
    )
}