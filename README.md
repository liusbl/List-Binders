# List-Binders

## Description

Use either SingleViewTypeAdapter to create simple lists, or MultiViewTypeAdapter for lists with multiple view types.

## TODO

- Provide overridable DefaultItemCallback for each item

- Not force extending ListItem for SingleViewTypeAdapter

- Validate that all types of enums were provided.

- Consider all the validation options.

- Find better solution then forcing enum usage.

- Passing viewHolder to itself looks weird (such as `viewHolder.onCreate(viewHolder)`).

- Fix documentation to actually create javadocs (right now it's empty)

- Decide if convertion to Kotlin is necessary, at least for sample.

- Sublist item?

- What if you were using stableID for viewType? Would that be possible somehow?

## Internal instructions for building

gradlew bintrayUpload
gradlew bintrayPublish