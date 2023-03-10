package uk.gov.dluhc.emsintegrationapi.testsupport.testdata

import org.apache.commons.lang3.RandomStringUtils
import uk.gov.dluhc.emsintegrationapi.testsupport.replaceSpacesWith
import uk.gov.dluhc.emsintegrationapi.testsupport.testdata.DataFaker.Companion.faker
import java.time.Instant
import java.time.LocalDate
import java.time.temporal.ChronoUnit.SECONDS
import java.util.concurrent.TimeUnit
import kotlin.random.Random

const val MIN_AGE = 18
const val MAX_AGE = 99
const val MIN_LENGTH = 5

fun getRandomIpAddress(): String =
    with(faker.internet()) {
        if (Random.nextBoolean()) ipV4Address() else ipV6Address()
    }

fun getPastDateTime(days: Int = MIN_LENGTH): Instant =
    faker.date().past(days, TimeUnit.DAYS).toInstant().truncatedTo(SECONDS)

fun getFutureDateTime(days: Int = MIN_LENGTH): Instant =
    faker.date().future(days, TimeUnit.DAYS).toInstant().truncatedTo(SECONDS)

fun getRandomGssCode() = "E${RandomStringUtils.randomNumeric(8)}"

fun getRandomEroId(): String = "${faker.address().city().lowercase()}-city-council"

fun getRandomEmailAddress(): String = "contact@${getRandomEroId().replaceSpacesWith("-")}.gov.uk"

fun getRandomDOB(): LocalDate =
    faker.date().birthday(MIN_AGE, MAX_AGE).toLocalDateTime().toLocalDate()

fun getRandomString(length: Int = MIN_LENGTH): String = RandomStringUtils.randomAlphabetic(length)

fun getRandomAlphaNumeric(maxLength: Int = MIN_LENGTH): String =
    RandomStringUtils.randomAlphanumeric(maxLength)

fun getRandomPastDate(inDays: Int = MIN_LENGTH): LocalDate =
    faker.date().past(inDays, TimeUnit.DAYS).toLocalDateTime().toLocalDate()
