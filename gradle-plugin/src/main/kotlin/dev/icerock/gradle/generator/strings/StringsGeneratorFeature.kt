/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

package dev.icerock.gradle.generator.strings

import dev.icerock.gradle.generator.ResourceGeneratorFeature
import dev.icerock.gradle.generator.SourceInfo
import dev.icerock.gradle.generator.MRGenerator

class StringsGeneratorFeature(private val info: SourceInfo): ResourceGeneratorFeature(info) {
    private val stringsFileTree = info.commonResources.matching{ include("MR/**/strings.xml") }
    override fun createCommonGenerator(): MRGenerator.Generator {
        return CommonStringsGenerator(info.sourceSet, stringsFileTree)
    }

    override fun createiOSGenerator(): MRGenerator.Generator  {
        return IosStringsGenerator(info.sourceSet, stringsFileTree)
    }

    override fun createAndroidGenerator(): MRGenerator.Generator {
        return AndroidStringsGenerator(info.sourceSet, stringsFileTree, info.androidRClassPackage)
    }

}