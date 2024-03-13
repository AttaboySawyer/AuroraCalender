package client

import com.raquo.laminar.api.L.{*, given}
import org.scalajs.dom
import org.scalajs.dom.HttpMethod
import types.Day
import types.Week
import types.Shift
import io.circe.parser._
import io.circe.generic.auto._
import utilities.JsonImplicits._
import scala.util.Random
import org.scalajs.dom.HTMLTableCellElement
import types.*
import components.cells._

case class AuroraClient() {

    val dataModelVar = Var(
      List(
        Week(
          "1",
          List(
            Day(
              Sunday,
              "1",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Monday,
              "2",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00")
                // Shift("Mia", "#3183D5", "12:00", "13:00"),
                // Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Tuesday,
              "3",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                // Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Wednesday,
              "4",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00")
                // Shift("Bob", "#41C94C", "12:00", "13:00"),
                // Shift("Mia", "#3183D5", "12:00", "13:00"),
                // Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Thursday,
              "5",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Friday,
              "6",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Saturday,
              "7",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            )
          )
        ),
        Week(
          "2",
          List(
            Day(
              Sunday,
              "8",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                // Shift("Mia", "#3183D5"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Monday,
              "9",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                // Shift("Mia", "#3183D5"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Tuesday,
              "10",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00")
                // Shift("Mia", "#3183D5"),
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Wednesday,
              "11",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                // Shift("Bob", "#41C94C"),
                // Shift("Mia", "#3183D5"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Thursday,
              "12",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Friday,
              "13",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Saturday,
              "14",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            )
          )
        ),
        Week(
          "3",
          List(
            Day(
              Sunday,
              "15",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Monday,
              "16",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Tuesday,
              "17",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Wednesday,
              "18",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Thursday,
              "19",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                // Shift("Mia", "#3183D5"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Friday,
              "20",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                // Shift("Bob", "#41C94C"),
                // Shift("Mia", "#3183D5"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Saturday,
              "21",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                // Shift("Bob", "#41C94C"),
                // Shift("Mia", "#3183D5"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            )
          )
        ),
        Week(
          "4",
          List(
            Day(
              Sunday,
              "22",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00")
                // Shift("Bob", "#41C94C"),
                // Shift("Mia", "#3183D5"),
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Monday,
              "23",
              "March",
              "2024",
              List(
                Shift("Alice", "#D2832D", "12:00", "13:00"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Tuesday,
              "24",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Wednesday,
              "25",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                Shift("Bob", "#41C94C", "12:00", "13:00"),
                Shift("Mia", "#3183D5", "12:00", "13:00")
                // Shift("David", "#C940C9")
              )
            ),
            Day(
              Thursday,
              "26",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Friday,
              "27",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            ),
            Day(
              Saturday,
              "28",
              "March",
              "2024",
              List(
                // Shift("Alice", "#D2832D"),
                // Shift("Bob", "#41C94C"),
                Shift("Mia", "#3183D5", "12:00", "13:00"),
                Shift("David", "#C940C9", "12:00", "13:00")
              )
            )
          )
        )
      )
    )

    val copiedContent = Var[Option[Shift]](None)
    val modal = Modal()

    val GETUrl: String = "http://localhost:9000/patients"

    def populateTable(respString: String): Unit = {
        // jsonDecoder(respString).map(item => dataModelVar.update(_ :+ item))
    }

    def jsonDecoder(jsonString: String): List[Week] =
        decode[List[Week]](jsonString) match {
            case Right(patients) => patients
            case Left(error) =>
                throw new RuntimeException(s"Failed to parse JSON: $error")
        }

    // def addEntryToDataModelVar(day: Day): EventStream[String] = {
    //     val random = new Random()
    //     val randomNumber = random.nextInt(90000000) + 10000000
    // val newPatient = Patient(
    //   "TB" + randomNumber.toString(),
    //   "",
    //   "",
    //   "",
    //   "2023-04-04",
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None,
    //   None
    // )
    //     dataModelVar.update((items) => {
    //         newPatient :: items
    //     })
    //     FetchStream.post(
    //       "http://localhost:9000/patients",
    //       _.body("")
    //     )
    // }

    // def updateEntryInDataModelVar(
    //     itemId: String,
    //     fieldName: String,
    //     newValue: String
    // ): EventStream[String] = {
    //     val item = dataModelVar.now().find(_.unitNumber == itemId).get
    //     println(s"Updating ${item.unitNumber} at field ${fieldName}...")
    //     dataModelVar
    //         .update((items) => {
    //             items.map(patient => {
    //                 patient.unitNumber == item.unitNumber match {
    //                     case true => {
    //                         // updatePatient(
    //                         //   patient,
    //                         //   fieldName,
    //                         //   newValue
    //                         // )
    //                     }
    //                     case false => patient
    //                 }
    //             })
    //         })
    //     FetchStream.put(
    //       s"http://localhost:9000/patients/${item.unitNumber}",
    //       _.body(
    //         ""
    //         // updatePatient(
    //         //   item,
    //         //   fieldName,
    //         //   newValue
    //         // )
    //         //     .toJson()
    //       )
    //     )
    // }

    // def deleteEntryInDataModelVar(unitNumber: String): EventStream[String] = {

    //     println("Deleting " + unitNumber + "...")
    //     dataModelVar.update((items) => {
    //         items.filter(_.unitNumber != unitNumber)
    //     })
    //     FetchStream.apply(
    //       method = _.DELETE,
    //       url = s"http://localhost:9000/patients/${unitNumber}"
    //     )
    // }

    // def updatePatient(
    //     patient: Patient,
    //     fieldName: String,
    //     newValue: String
    // ): Patient = {
    //     fieldName match {
    //         case "unitNumber" =>
    //             println("Cannot change unitnumber")
    //         case "lastName"  => patient.lastName = newValue
    //         case "firstName" => patient.firstName = newValue
    //         case "sex"       => patient.sex = newValue
    //         case "dob"       => patient.dob = newValue
    //         case "hcn"       => patient.hcn = Option(newValue)
    //         case "family"    => patient.family = Option(newValue)
    //         case "famPriv"   => patient.famPriv = Option(newValue)
    //         case "hosp"      => patient.hosp = Option(newValue)
    //         case "flag"      => patient.flag = Option(newValue)
    //         case "address1" =>
    //             patient.address1 = Option(newValue)
    //         case "address2" =>
    //             patient.address2 = Option(newValue)
    //         case "city" => patient.city = Option(newValue)
    //         case "province" =>
    //             patient.province = Option(newValue)
    //         case "postalCode" =>
    //             patient.postalCode = Option(newValue)
    //         case "homePhoneNumber" =>
    //             patient.homePhoneNumber = Option(newValue)
    //         case "workPhoneNumber" =>
    //             patient.workPhoneNumber = Option(newValue)
    //         case "OHIP" => patient.OHIP = Option(newValue)
    //         case "familyPhysician" =>
    //             patient.familyPhysician = Option(newValue)
    //         case "attending" =>
    //             patient.attending = Option(newValue)
    //         case "collab1" => patient.collab1 = Option(newValue)
    //         case "collab2" => patient.collab2 = Option(newValue)
    //     }
    //     patient
    // }

}
