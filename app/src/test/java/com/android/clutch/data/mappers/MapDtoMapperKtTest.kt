package com.android.clutch.data.mappers

import com.android.clutch.data.remote.dto.MapDto
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class MapDtoMapperKtTest {

    @Test
    fun `WHEN toMapModel with values EXPECT model has value`() {
        val mapDto = MapDto(
            id = 1234,
            name = "map",
            imageUrl = "map_url",
            videogameVersions = listOf()
        )
        val res = mapDto.toMapModel()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }

    @Test
    fun `WHEN toMapModel with null EXPECT empty String`() {
        val mapDto = MapDto(
            id = 1234,
            name = null,
            imageUrl = null,
            videogameVersions = listOf()
        )
        val res = mapDto.toMapModel()

        MatcherAssert.assertThat(res.name, CoreMatchers.`is`(""))
        MatcherAssert.assertThat(res.imageUrl, CoreMatchers.`is`(""))
    }

}