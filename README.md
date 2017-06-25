# EMedicationSystem : a smartphone-based e-medication system for hospitalized patients

E-medication has become very popular due to its ability to enhance safety and quality of
the prescription process. It the simple app, where patient track their daily drug report from own hospital, it is just dem project.

### JSON Data Format
patients data
```sh
{
    "patients": [
        {
                "personalid": "11111111111",
                "name": "Ram Prasad",
				"age": "22",
                "email": "ram@gmail.com",
                "address": "kathmandu, Nepal",
                "gender" : "male",
                "code" : "123456,654321"
        },
		{
                "personalid": "22222222222",
                "name": "Sita Devi",
				"age": "50",
                "email": "sita@gmail.com",
                "address": "lalitpur, Nepal",
                "gender" : "female",
                "code" : "222333,333222"
        },
		{
                "personalid": "33333333333",
                "name": "Hari Bahadur",
				"age": "10",
                "email": "hari@gmail.com",
                "address": "Pokhara, Nepal",
                "gender" : "male",
                "code" : "999666,666999"
        }
        
  ]
}
                                                            

```
medication data
```sh
{
  "CurrentMedication": [
    {
      "personalid": "11111111111",
      "name": "Ram Prasad",
      "MedicationList": [
         {
          "id":"1",
          "medicinename": "Salbutamol",
          "dosage": "180 mg",
          "time": "5 times per day",
          "diagnosis": "Aasthma",
          "initiatedon": "01/01/2010",
          "status": "Ongoing",
          "remarks": ""
        },
        {
          "id":"2",
          "medicinename": "Oral prednisone",
          "dosage": "40 mg",
          "time": "once a day",
          "diagnosis": "Aasthma",
          "initiatedon": "01/01/2010",
          "status": "Ongoing",
          "remarks": ""
        }
      ]
    },
    {
      "personalid": "22222222222",
      "name": "Sita Devi",
      "MedicationList": [
       {
        "id":"1",
        "medicinename": "Metformin",
        "dosage": "1000 mg",
        "time": "three times  a day",
        "diagnosis": "Diabetes",
        "initiatedon": "14/12/2010",
        "status": "New",
        "remarks": ""
       },
        {
         "id":"2",
          "medicinename": "Amoxicillin",
          "dosage": "500 mg",
          "time": "twice a day",
          "diagnosis": "Pneumonia(with diabetes mellitus type 2)",
          "initiatedon": "05/12/2010",
          "status": "Ongoing",
          "remarks": ""
        },
        {
        "id":"3",
          "medicinename": "Ceftriaxone Img",
          "dosage": "10 mg",
          "time": "once a day",
          "diagnosis": "Pneumonia",
          "initiatedon": "10/12/2010",
          "status": "Ongoing",
          "remarks": ""
        }
    ]
  },
  {
    "personalid": "33333333333",
    "name": "Hari Bahadur",
    "MedicationList": [
      {
      "id":"1",
        "medicinename": "Enalapril",
        "dosage": "5 mg",
        "time": "once a day",
        "diagnosis": "Ischemic heart disease",
        "initiatedon": "10/12/2010",
        "status": "New",
        "remarks": ""
      },
      {
      "id":"2",
      "medicinename": "Clopidogrel(anti- platelet agent)",
      "dosage": "100 mg",
      "time": "once a day",
      "diagnosis": "Ischemic heart disease",
      "initiatedon": "05/12/2010",
      "status": "New",
      "remarks": ""
    },
      {
      "id":"3",
        "medicinename": "Morphine",
        "dosage": "15-30 mg",
        "time": "three times a day",
        "diagnosis": "Ischemic heart disease",
        "initiatedon": "01/01/2010",
        "status": "Ongoing",
        "remarks": ""
      }
     
  ]
}
]
}
```
### How to Clone EMedicationSystem?

$ git clone https://github.com/dharmakshetri/EMedicationSystem.git
 
 
### Snapshots

--- 
![User login](http://dharmakshetri.com.np/img/ems/device-2016-11-30-053314.png)
---
![List of Drugs](http://dharmakshetri.com.np/img/ems/device-2016-11-30-053612.png)
---
![Drug Details](http://dharmakshetri.com.np/img/ems/device-2016-11-30-053639.png)

### About Me

I am an android engineer, currently located in Fremont, CA.

If you have any idea and wann chat with me, please visit my blog [PrAndroid](http://www.prandroid.com) and [CodingWorkspace](http://www.codingworkspace.com). More about me please visit my personal website:[DHARMAKSHETRI.me](http://dharmakshetri.me/).
