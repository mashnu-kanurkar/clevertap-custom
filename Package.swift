// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "ClevertapCustom",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "ClevertapCustom",
            targets: ["CleverTapCustomPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "CleverTapCustomPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CleverTapCustomPlugin"),
        .testTarget(
            name: "CleverTapCustomPluginTests",
            dependencies: ["CleverTapCustomPlugin"],
            path: "ios/Tests/CleverTapCustomPluginTests")
    ]
)