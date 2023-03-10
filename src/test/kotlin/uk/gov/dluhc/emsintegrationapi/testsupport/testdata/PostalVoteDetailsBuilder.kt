package uk.gov.dluhc.emsintegrationapi.testsupport.testdata

import org.testcontainers.utility.Base58.randomString
import uk.gov.dluhc.emsintegrationapi.database.entity.Address
import uk.gov.dluhc.emsintegrationapi.database.entity.PostalVoteDetails
import java.time.LocalDate

fun buildPostalVoteDetailsEntity(
    ballotAddress: Address? = buildAddressEntity(),
    ballotAddressReason: String? = randomString(10),
    voteForSingleDate: LocalDate? = getRandomPastDate(),
    voteStartDate: LocalDate? = getRandomPastDate(10),
    voteEndDate: LocalDate? = getRandomPastDate(1),
    voteUntilFurtherNotice: Boolean = false
) = PostalVoteDetails(
    ballotAddress = ballotAddress,
    ballotAddressReason = ballotAddressReason,
    voteForSingleDate = voteForSingleDate,
    voteStartDate = voteStartDate,
    voteEndDate = voteEndDate,
    voteUntilFurtherNotice = voteUntilFurtherNotice
)
