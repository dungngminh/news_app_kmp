//
//  AboutListView.swift
//  iosApp
//
//  Created by Nguyễn Minh Dũng on 19/5/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import shared
import SwiftUI

struct AboutListView: View {
    private struct InfoData: Hashable {
        let title: String
        let content: String
    }
    
    private let items: [InfoData] = {
        let platform = Platform()
        
        return [
            .init(title: "OS Name", content: platform.osName),
            .init(title: "OS Version", content: platform.osVersion),
            .init(title: "Device Density", content: "@\(platform.density)")
        ]
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading){
                    Text(item.title)
                        .foregroundStyle(.secondary)
                    Text(item.content)
                        .foregroundStyle(.primary)
                }
            }
        }
    }
}
