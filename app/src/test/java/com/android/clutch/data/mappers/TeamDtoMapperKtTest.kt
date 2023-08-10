package com.android.clutch.data.mappers

import com.android.clutch.data.local.model.TeamLocal
import com.android.clutch.data.remote.dto.TeamDto
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class TeamDtoMapperKtTest {


    @Test
    fun `WHEN toAgentModel with values EXPECT model has value`() {
        val teamDto = TeamDto(
            acronym = "ABC",
            id = 1234,
            imageUrl = "photo_url",
            location = "EU",
            name = "ABC Team",
            players = listOf()
        )
        val res = teamDto.toTeamModel()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }

    @Test
    fun `WHEN toAgentModel with null EXPECT custom value`() {
        val teamDto = TeamDto(
            acronym = null,
            id = 1234,
            imageUrl = "photo_url",
            location = null,
            name = "ABC Team",
            players = listOf()
        )
        val res = teamDto.toTeamModel()

        MatcherAssert.assertThat(res.acronym, CoreMatchers.`is`("Ninguno"))
        MatcherAssert.assertThat(res.location, CoreMatchers.`is`("Desconocida"))
    }

    @Test
    fun `WHEN toAgentLocal with values EXPECT model has value`() {
        val teamDto = TeamDto(
            acronym = "ABC",
            id = 1234,
            imageUrl = "photo_url",
            location = "EU",
            name = "ABC Team",
            players = listOf()
        )
        val res = teamDto.toTeamLocal()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }

    @Test
    fun `WHEN toAgentLocal with null EXPECT custom value`() {
        val teamDto = TeamDto(
            acronym = null,
            id = 1234,
            imageUrl = "photo_url",
            location = null,
            name = "ABC Team",
            players = listOf()
        )
        val res = teamDto.toTeamLocal()

        MatcherAssert.assertThat(res.acronym, CoreMatchers.`is`("Ninguno"))
        MatcherAssert.assertThat(res.location, CoreMatchers.`is`("Desconocida"))
    }

    @Test
    fun `WHEN LocaltoAgentModel with values EXPECT model has value`() {
        val teamLocal = TeamLocal(
            acronym = "ABC",
            id = 1234,
            imageUrl = "photo_url",
            location = "EU",
            name = "ABC Team",
        )
        val res = teamLocal.toTeamModel()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }
}