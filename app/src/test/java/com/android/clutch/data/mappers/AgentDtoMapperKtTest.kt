package com.android.clutch.data.mappers

import com.android.clutch.data.remote.dto.AgentDto
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Test

class AgentDtoMapperKtTest {

    @Test
    fun `WHEN toAgentModel with values Expect model has value`() {
        val agentDto = AgentDto(
            id = 1234,
            name = "Sample Name",
            portraitUrl = "htttp://www.photo.com/1234",
            gameVersion = listOf()
        )
        val res = agentDto.toAgentModel()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }

    @Test
    fun `WHEN toAgentModel with null Expect empty string`() {
        val agentDto = AgentDto(
            id = 1234,
            name = null,
            portraitUrl = "htttp://www.photo.com/1234",
            gameVersion = listOf()
        )
        val res = agentDto.toAgentModel()

        MatcherAssert.assertThat(res.name, CoreMatchers.`is`(""))
    }

    @Test
    fun `WHEN toAgentLocal with values Expect model has value`() {
        val agentDto = AgentDto(
            id = 1234,
            name = "Sample Name",
            portraitUrl = "htttp://www.photo.com/1234",
            gameVersion = listOf()
        )
        val res = agentDto.toAgentLocal()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }

    @Test
    fun `WHEN toAgentLocal with null Expect empty string`() {
        val agentDto = AgentDto(
            id = 1234,
            name = null,
            portraitUrl = "htttp://www.photo.com/1234",
            gameVersion = listOf()
        )
        val res = agentDto.toAgentLocal()

        MatcherAssert.assertThat(res.name, CoreMatchers.`is`(""))
    }

    @Test
    fun `WHEN LocaltoAgentModel with values Expect model has value`() {
        val agentDto = AgentDto(
            id = 1234,
            name = "Sample Name",
            portraitUrl = "htttp://www.photo.com/1234",
            gameVersion = listOf()
        )
        val res = agentDto.toAgentLocal()

        MatcherAssert.assertThat(res.id, CoreMatchers.`is`(1234))
    }

    @Test
    fun `WHEN LocaltoAgentModel with null Expect empty string`() {
        val agentDto = AgentDto(
            id = 1234,
            name = null,
            portraitUrl = "htttp://www.photo.com/1234",
            gameVersion = listOf()
        )
        val res = agentDto.toAgentLocal()

        MatcherAssert.assertThat(res.name, CoreMatchers.`is`(""))
    }
}