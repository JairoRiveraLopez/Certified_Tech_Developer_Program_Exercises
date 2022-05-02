$req = Invoke-WebRequest -Method Get -Uri https://raw.githubusercontent.com/olea/lemarios/master/nombres-propios-es.txt
$nombresConA = $req.Content.split("`n") | Where-Object { $_ -like
"A*" }
$nombresConL = $req.Content.split("`n") | Where-Object { $_ -like
"L*" }

$nombresSinAL = $req.Content.split("`n") | Where-Object { ($_ -NotLike
"A*") -and ($_ -NotLike"L*")}

1..5 | ForEach-Object {
$random = Get-Random -Minimum 0 -Maximum $($nombresConA.count-1)
$nombresConA[$random]
}

1..5 | ForEach-Object {
$random = Get-Random -Minimum 0 -Maximum $($nombresConL.count-1)
$nombresConL[$random]
}

1..5 | ForEach-Object {
$random = Get-Random -Minimum 0 -Maximum $($nombresSinAL.count-1)
$nombresSinAL[$random]
}

